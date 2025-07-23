package br.com.barbearia.DTO;

import java.time.LocalDate;

public class SchedulingDTO {
	
	private String nome;
	private LocalDate data;
	private String barbeiro;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getBarbeiro() {
		return barbeiro;
	}
	
	public void setBarbeiro(String barbeiro) {
		this.barbeiro = barbeiro;
	}
}