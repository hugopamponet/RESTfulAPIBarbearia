package br.com.barbearia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	List<UserModel> findByNomeContainingIgnoreCase(String nome);
	
	Optional<UserModel> findByNome(String nome);
	boolean existsByNome(String nome);
	boolean existsByEmail(String email);
}