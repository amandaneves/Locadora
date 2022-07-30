package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Usuario {
	private SimpleStringProperty nome;
	private SimpleIntegerProperty idade;
	
	public SimpleStringProperty getNomeProperty() {
		return this.nome;
	}
	
	public String getNome(){
		return nome.getValue();
	}

	public void setNome(SimpleStringProperty nome) {
		this.nome = nome;
	}

	public SimpleIntegerProperty getIdadeProperty() {
		return idade;
	}
	
	public Integer getIdade(){
		return idade.getValue();
	}

	public void setIdade(SimpleIntegerProperty idade) {
		this.idade = idade;
	}

	public Usuario(String nome, int idade) {
		this.nome = new SimpleStringProperty(nome);
		this.idade = new SimpleIntegerProperty(idade);
	}
}
