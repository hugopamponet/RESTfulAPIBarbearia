package br.com.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbearia.model.SchedulingModel;

public interface SchedulingRopository extends JpaRepository<SchedulingModel, Long>{

}