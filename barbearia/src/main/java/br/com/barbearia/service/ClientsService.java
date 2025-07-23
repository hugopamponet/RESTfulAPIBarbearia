package br.com.barbearia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.barbearia.DTO.ClientsDTO;
import br.com.barbearia.model.ClientsModel;
import br.com.barbearia.repository.ClientsRepository;

@Service
public record ClientsService(ClientsRepository clientsRepository) {

	public void saveClient(ClientsDTO dto) {
		ClientsModel client = new ClientsModel();
		client.setNameCustomer(dto.getNameCustomer());
		client.setMail(dto.getMail());
		client.setSex(dto.getSex());
		client.setTelephone(dto.getTelephone());
		
		clientsRepository.save(client);
	}
	
	public List<ClientsDTO> getAllClients() {
		return clientsRepository.findAll().stream().map(client -> {
			ClientsDTO dto = new ClientsDTO();
			dto.setNameCustomer(client.getNameCustomer());
			dto.setMail(client.getMail());
			dto.setSex(client.getSex());
			dto.setTelephone(client.getTelephone());
			return dto;
		}).collect(Collectors.toList());
	}
}