package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Filme {
	private SimpleStringProperty nomeFilme;
	private SimpleIntegerProperty ano_lanc;
	private SimpleIntegerProperty categoria;
	private SimpleDoubleProperty valorDiaria;
	private Boolean alugado;
	
	public Filme(String nomeFilme, double valorDiaria){
		this.nomeFilme = new SimpleStringProperty(nomeFilme);
		this.valorDiaria = new SimpleDoubleProperty(valorDiaria);
	}

	public SimpleStringProperty getNomeFilmeProperty() {
		return this.nomeFilme;
	}

	public void setNomeFilme(SimpleStringProperty nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public String getNomeFilme(){
		return nomeFilme.getValue();
	}

	public SimpleIntegerProperty getAno_lancProperty() {
		return this.ano_lanc;
	}

	public void setAno_lanc(SimpleIntegerProperty ano_lanc) {
		this.ano_lanc = ano_lanc;
	}

	public SimpleIntegerProperty getCategoriaProperty() {
		return this.categoria;
	}

	public void setCategoria(SimpleIntegerProperty categoria) {
		this.categoria = categoria;
	}

	public SimpleDoubleProperty getValorDiariaProperty() {
		return this.valorDiaria;
	}

	public void setValorDiaria(SimpleDoubleProperty valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public Double getValorDiaria(){
		return valorDiaria.getValue();
	}

	public Boolean getAlugado() {
		return this.alugado;
	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}
	
}
