package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Locacao {
	private SimpleStringProperty filmeLocado;
	private SimpleStringProperty usuarioLocado;
	private SimpleDoubleProperty valorTotal; 
	private SimpleStringProperty DtLocacao;
	private SimpleStringProperty DtEntrega;
		
	public Locacao(String filme, String usuario, String dtLocacao ){
		this.filmeLocado = new SimpleStringProperty(filme);
		this.usuarioLocado = new SimpleStringProperty(usuario);
		this.DtLocacao = new SimpleStringProperty(dtLocacao);
	}

	public SimpleStringProperty getFilmeLocadoProperty() {
		return filmeLocado;
	}

	public void setFilmeLocado(SimpleStringProperty filmeLocado) {
		this.filmeLocado = filmeLocado;
	}

	public SimpleStringProperty getUsuarioLocadoProperty() {
		return usuarioLocado;
	}

	public void setUsuarioLocado(SimpleStringProperty usuarioLocado) {
		this.usuarioLocado = usuarioLocado;
	}

	public SimpleDoubleProperty getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(SimpleDoubleProperty valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SimpleStringProperty getDtLocacaoProperty() {
		return DtLocacao;
	}

	public void setDtLocacao(SimpleStringProperty dtLocacao) {
		DtLocacao = dtLocacao;
	}

	public SimpleStringProperty getDtEntrega() {
		return DtEntrega;
	}

	public void setDtEntrega(SimpleStringProperty dtEntrega) {
		DtEntrega = dtEntrega;
	}
	
}
