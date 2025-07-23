package br.com.barbearia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.barbearia.DTO.SchedulingDTO;
import br.com.barbearia.model.SchedulingModel;
import br.com.barbearia.repository.SchedulingRopository;


@Service
public record SchedulingService(SchedulingRopository agendamentoRopository) {
	
	public SchedulingModel salvarAgendamento(SchedulingDTO dto) {
		SchedulingModel model = new SchedulingModel();
		model.setNomeDoCliente(dto.getNome());
		model.setData(dto.getData());
		model.setBarbeiro(dto.getBarbeiro());
		
		return agendamentoRopository.save(model);
	}
	
	public List<SchedulingModel> listarTodos() {
		return agendamentoRopository.findAll();
	}
}