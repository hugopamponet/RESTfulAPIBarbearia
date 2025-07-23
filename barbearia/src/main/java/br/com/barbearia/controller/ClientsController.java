package br.com.barbearia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbearia.DTO.ClientsDTO;
import br.com.barbearia.service.ClientsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clients")
public record ClientsController(ClientsService clientsService) {

	@PostMapping
	public ResponseEntity<Void> createClient(@RequestBody ClientsDTO dto) {
		clientsService.saveClient(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ClientsDTO>> getAllClients() {
		return ResponseEntity.ok(clientsService.getAllClients());
	}
}