package br.com.pratica.crudestudante.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estudante {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	private String numeroPassaporte;
	
	
	public Estudante() {}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNumeroPassaporte() {
		return numeroPassaporte;
	}


	public void setNumeroPassaporte(String numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}
	
	

}
