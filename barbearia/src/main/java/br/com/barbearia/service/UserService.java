package br.com.barbearia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbearia.DTO.RegisterDTO;
import br.com.barbearia.DTO.LoginDTO;
import br.com.barbearia.model.UserModel;
import br.com.barbearia.repository.UserRepository;

@Service
public record UserService(UserRepository userRepository) {

	public ResponseEntity<String> cadastrar(RegisterDTO dto) {
		if (userRepository.existsByNome(dto.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe.");
		}
		
		if(userRepository.existsByEmail(dto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já existe.");
		}
		
		UserModel usuario = new UserModel();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setCargo(dto.getCargo());
		usuario.setSexo(dto.getSexo());
		usuario.setSenha(dto.getSenha());
		
		userRepository.save(usuario);
		
		return ResponseEntity.ok("Cadastro Realizado com sucesso!");
	}
	
	public ResponseEntity<String> login(LoginDTO dto) {
		Optional<UserModel> usuario = userRepository.findByNome(dto.getNome());
		
		if (usuario.isPresent() && usuario.get().getSenha().equals(dto.getSenha())) {
			return ResponseEntity.ok("Login realizado");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos.");
	}
	
	public List<UserModel> buscarTodos() {
		return userRepository.findAll();
	}
	
	public Optional<UserModel> atualizarPorNome(String nome, UserModel dadosAtualizados) {
		return userRepository.findByNome(nome).map(usuarioExistente -> {
			usuarioExistente.setNome(dadosAtualizados.getNome());
			usuarioExistente.setEmail(dadosAtualizados.getEmail());
			usuarioExistente.setCargo(dadosAtualizados.getCargo());
			usuarioExistente.setSexo(dadosAtualizados.getSexo());
			usuarioExistente.setSenha(dadosAtualizados.getSenha());
			
			return userRepository.save(usuarioExistente);
		});
	}
	
	public boolean deletarPorNome(String Nome) {
		Optional<UserModel> usuario = userRepository.findByNome(Nome);
		if (usuario.isPresent()) {
			userRepository.delete(usuario.get());
			return true;
		}
		
		return false;
	}
}