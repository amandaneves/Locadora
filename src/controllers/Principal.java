package controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;
import models.Filme;
import models.Locacao;
import models.Usuario;

public class Principal extends Stage {

	@FXML
	private Tab tabLocacao;

	@FXML
	private TableView<Locacao> tbvLocacao;

	@FXML
	private Button btnAdicionar_locacao;

	@FXML
	private Button btnDevolver_locacao;

	@FXML
	private AnchorPane acpLocacao_manut;

	@FXML
	private ComboBox<Usuario> cbxCliente;

	@FXML
	private ComboBox<Filme> cbxFilme;

	@FXML
	private TextField txtVlr_diaria_locacao;

	@FXML
	private TextField txtDt_inicial;

	@FXML
	private TextField txtDt_final;

	@FXML
	private Button btnConfirmar_locacao;

	@FXML
	private Button btnCancelar_locacao;

	@FXML
	private Tab tabFilmes;

	@FXML
	private TableView<Filme> tbvFilme;

	@FXML
	private AnchorPane acpFilme_manut;

	@FXML
	private TextField txtNome_filme;

	@FXML
	private TextField txtVlr_diaria_filme;

	@FXML
	private TextField txtAno_lanc;

	@FXML
	private Label lblClassificacao;

	@FXML
	private Button btnAdicionar_filme;

	@FXML
	private Button btnExcluir_filme;

	@FXML
	private Button btnConfirmar_filme;

	@FXML
	private Button btnCancelar_filme;

	@FXML
	private Tab tabClientes;

	@FXML
	private TableView<Usuario> tbvCliente;

	@FXML
	private Button btnAdicionar_cliente;

	@FXML
	private Button btnExcluir_cliente;

	@FXML
	private AnchorPane acpCliente_manut;

	@FXML
	private TextField txtNome_cliente;

	@FXML
	private TextField txtIdade;

	@FXML
	private Button btnConfirmar_cliente;

	@FXML
	private Button btnCancelar_cliente;

	@FXML
	private Button btnAtualiza_classif;
	
	@FXML
	private TableColumn<Usuario, String> clnNome_cli;

	@FXML
	private TableColumn<Usuario, Integer> clnIdade_cli;

	@FXML
	private TableColumn<Filme, String> clnNome_filme;

	@FXML
	private TableColumn<Filme, Double> clnValor_diaria;
	
	@FXML
	private TableColumn<Locacao, String> clnCliente_nome;
	
	@FXML
	private TableColumn<Locacao, String> clnFilme_nome;
	
	@FXML
	private TableColumn<Locacao, String> clnDt_inicial;
	
	@FXML
	private TableColumn<Locacao, String> clnDt_final;
	
	@FXML
	private TableColumn<Locacao, Double> clnValor_final;

	ObservableList<Usuario> Usu;

	ObservableList<Filme> Fil;

	ObservableList<Locacao> Loc;

	public Principal() throws IOException {
		FXMLLoader myfrm = new FXMLLoader(getClass().getResource("../views/Principal.fxml"));
		myfrm.setController(this);
		Scene myscene = new Scene(myfrm.load());
		this.setScene(myscene);
		myscene.getStylesheets().add(getClass().getResource("../styles/standard.css").toExternalForm());
		this.setTitle("Locadora");
		this.setResizable(false);

		this.setOnShown(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {

				try {

					// Desabilitando objetos que serao usados depois
					acpCliente_manut.setDisable(true);
					acpFilme_manut.setDisable(true);
					acpLocacao_manut.setDisable(true);
					txtVlr_diaria_filme.setDisable(true);
					
					lblClassificacao.setText("");
					cbxCliente.setPromptText("Selecione...");
					cbxFilme.setPromptText("Selecione...");
					
					clnNome_cli.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
					clnIdade_cli.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("idade"));

					clnNome_filme.setCellValueFactory(new PropertyValueFactory<Filme, String>("nomeFilme"));
					clnValor_diaria.setCellValueFactory(new PropertyValueFactory<Filme, Double>("valorDiaria"));
					
					clnCliente_nome.setCellValueFactory(new PropertyValueFactory<Locacao, String>("clienteLocado"));
					clnFilme_nome.setCellValueFactory(new PropertyValueFactory<Locacao, String>("filmeLocado"));
					clnDt_inicial.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dtLocacao"));
					clnDt_final.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dtEntrega"));
					clnValor_final.setCellValueFactory(new PropertyValueFactory<Locacao, Double>("valorTotal"));
					

					Usu = FXCollections.observableArrayList();
					Fil = FXCollections.observableArrayList();
					Loc = FXCollections.observableArrayList();
					tbvCliente.setItems(FXCollections.observableArrayList(Usu));
					tbvFilme.setItems(FXCollections.observableArrayList(Fil));
					tbvLocacao.setItems(FXCollections.observableArrayList(Loc));
					

				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	@FXML
	void btnAdicionar_cliente_Click(ActionEvent event) {
		acpCliente_manut.setDisable(false);
	}

	@FXML
	void btnAdicionar_filme_Click(ActionEvent event) {
		acpFilme_manut.setDisable(false);
	}

	@FXML
	void btnAdicionar_locacao_Click(ActionEvent event) {
		acpLocacao_manut.setDisable(false);
		cbxCliente.setConverter(new StringConverter<Usuario>() {
            @Override
            public String toString(Usuario object) {
                if(object != null){
                    return object.getNome();
                }
                return null;
            }

            @Override
            public Usuario fromString(String string) {
                return null;
            }
        });
		cbxCliente.setItems(FXCollections.observableArrayList(Usu));
		cbxFilme.setConverter(new StringConverter<Filme>() {
            @Override
            public String toString(Filme object) {
                if(object != null){
                    return object.getNomeFilme();
                }
                return null;
            }

            @Override
            public Filme fromString(String string) {
                return null;
            }
        });
		cbxFilme.setItems(FXCollections.observableArrayList(Fil));
	}

	@FXML
	void btnCancelar_cliente_Click(ActionEvent event) {
		txtNome_cliente.clear();
		txtIdade.clear();
		acpCliente_manut.setDisable(true);
	}

	@FXML
	void btnCancelar_filme_Click(ActionEvent event) {
		txtNome_filme.clear();
		txtVlr_diaria_filme.clear();
		txtAno_lanc.clear();
		lblClassificacao.setText("");
		acpFilme_manut.setDisable(true);
	}

	@FXML
	void btnCancelar_locacao_Click(ActionEvent event) {
		cbxCliente.valueProperty().set(null);
		cbxCliente.setPromptText("Selecione...");
		cbxFilme.valueProperty().set(null);
		cbxFilme.setPromptText("Selecione...");
		txtVlr_diaria_locacao.clear();
		txtDt_inicial.clear();
		txtDt_final.clear();
		acpLocacao_manut.setDisable(true);
	}

	@FXML
	void btnConfirmar_cliente_Click(ActionEvent event) {
		Usu.add(new Usuario(txtNome_cliente.getText(), Integer.parseInt(txtIdade.getText())));
		tbvCliente.setItems(FXCollections.observableArrayList(Usu));
		txtNome_cliente.clear();
		txtIdade.clear();
		acpCliente_manut.setDisable(true);
	}

	@FXML
	void btnConfirmar_filme_Click(ActionEvent event) {
		Fil.add(new Filme(txtNome_filme.getText(), Double.parseDouble(txtVlr_diaria_filme.getText())));
		tbvFilme.setItems(FXCollections.observableArrayList(Fil));
		txtNome_filme.clear();
		txtAno_lanc.clear();
		lblClassificacao.setText("");
		txtVlr_diaria_filme.clear();
		acpFilme_manut.setDisable(true);
	}
	
	@FXML
	void btnAtualiza_classif_Click(ActionEvent event) {

		if(Integer.parseInt(txtAno_lanc.getText()) == 2015){
			lblClassificacao.setText("Lançamento");
			txtVlr_diaria_filme.setText("6.00");
	    }
		else if(Integer.parseInt(txtAno_lanc.getText()) >= 2013 && Integer.parseInt(txtAno_lanc.getText()) < 2015) {
			lblClassificacao.setText("Atual");
			txtVlr_diaria_filme.setText("4.00");
		}
		else if(Integer.parseInt(txtAno_lanc.getText()) < 2013){
			lblClassificacao.setText("Antigo");
			txtVlr_diaria_filme.setText("2.00");
		}
		else{
			lblClassificacao.setText("Iválido");
			txtVlr_diaria_filme.setText("");
		}
				
	}

	@FXML
	void btnConfirmar_locacao_Click(ActionEvent event) {
		Loc.add(new Locacao(cbxCliente.getSelectionModel().getSelectedItem().toString(), cbxFilme.getSelectionModel().getSelectedItem().toString(), txtDt_inicial.getText()));
		/*if(txtDt_final == null){
			txtDt_final.setText("0");
		}
		if(txtVlr_diaria_locacao == null){
			txtVlr_diaria_locacao.setText("0");
		}
		*/
		tbvLocacao.setItems(FXCollections.observableArrayList(Loc));
	}

	@FXML
	void btnDevolver_locacao_Click(ActionEvent event) {

	}

	@FXML
	void btnExcluir_cliente_Click(ActionEvent event) {
		int Posicao = tbvCliente.getSelectionModel().getSelectedIndex();
		System.out.println(tbvCliente.getSelectionModel().getSelectedIndex());
		System.out.println(Usu.size());
		Usu.remove(Posicao);
		tbvCliente.setItems(FXCollections.observableArrayList(Usu));
		tbvCliente.getSelectionModel().clearSelection();

	}

	@FXML
	void btnExcluir_filme_Click(ActionEvent event) {
		int Posicao = tbvFilme.getSelectionModel().getSelectedIndex();
		System.out.println(tbvFilme.getSelectionModel().getSelectedIndex());
		System.out.println(Fil.size());
		Fil.remove(Posicao);
		tbvFilme.setItems(FXCollections.observableArrayList(Fil));
		tbvCliente.getSelectionModel().clearSelection();
	}
}
