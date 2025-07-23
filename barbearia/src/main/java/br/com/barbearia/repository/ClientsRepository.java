package br.com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.model.ClientsModel;

public interface ClientsRepository extends JpaRepository<ClientsModel, Long>{

}