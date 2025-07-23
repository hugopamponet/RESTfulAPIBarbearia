package br.com.barbearia.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scheduling")
public class SchedulingModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name ="nomeDoCliente")
	private String nomeDoCliente;
	
	@Column(name ="data")
	private LocalDate data;
	
	@Column(name ="barbeiro")
	private String Barbeiro;

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getBarbeiro() {
		return Barbeiro;
	}

	public void setBarbeiro(String barbeiro) {
		Barbeiro = barbeiro;
	}
}