package br.com.barbearia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbearia.DTO.SchedulingDTO;
import br.com.barbearia.model.SchedulingModel;
import br.com.barbearia.service.SchedulingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/scheduling")
public record SchedulingController(SchedulingService service) {

	@PostMapping
	public SchedulingModel criarAgendamento(@RequestBody SchedulingDTO dto) {
		return service.salvarAgendamento(dto);
	}
	
	public List<SchedulingModel> listarAgendamentos() {
		return service.listarTodos();
	}
}