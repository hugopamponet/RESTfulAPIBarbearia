package br.com.barbearia.DTO;

import br.com.barbearia.enumeration.SexEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ClientsDTO {

	private String nameCustomer;
	
	private String mail;
	
	private String telephone;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
}