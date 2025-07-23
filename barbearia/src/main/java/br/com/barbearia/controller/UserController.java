package br.com.barbearia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbearia.DTO.RegisterDTO;
import br.com.barbearia.DTO.LoginDTO;
import br.com.barbearia.model.UserModel;
import br.com.barbearia.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public record UserController(UserService userService) {

	@PostMapping("/register")
	public ResponseEntity<String> cadastrar(@RequestBody RegisterDTO dto) {
		return userService.cadastrar(dto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
		return userService.login(dto);
	}

	
	@GetMapping("/consulta")
	public List<UserModel> buscarUsuario() {
		return userService.buscarTodos();
	}
	
	@PutMapping("/nome/{nome}")
	public ResponseEntity<UserModel> atualizarPorNome(@PathVariable String nome, @RequestBody UserModel dadosAtualizados) {
		return userService.atualizarPorNome(nome, dadosAtualizados)
				.map(usuario -> ResponseEntity.ok(usuario))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/nome/{nome}")
	public ResponseEntity<Void> deletarPorNome(@PathVariable String nome) {
		boolean deletado = userService.deletarPorNome(nome);
		
		return deletado
				? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}
}
