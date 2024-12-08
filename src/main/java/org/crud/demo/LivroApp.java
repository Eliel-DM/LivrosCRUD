package org.crud.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.crud.demo.Livro;
import org.crud.demo.LivroController;

public class LivroApp extends Application {

    private LivroController livroController = new LivroController();
    private TableView<Livro> tabelaLivros;
    private ObservableList<Livro> livros;

    @Override
    public void start(Stage primaryStage) {
        // Layout principal
        VBox layoutPrincipal = new VBox(10);
        layoutPrincipal.setStyle("-fx-padding: 10;");

        // Formulário
        HBox formulario = new HBox(10);
        TextField txtId = new TextField();
        txtId.setPromptText("ID (para atualizar/remover)");
        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Título");
        TextField txtAutor = new TextField();
        txtAutor.setPromptText("Autor");
        TextField txtAno = new TextField();
        txtAno.setPromptText("Ano de Publicação");
        TextField txtGenero = new TextField();
        txtGenero.setPromptText("Gênero");

        formulario.getChildren().addAll(txtId, txtTitulo, txtAutor, txtAno, txtGenero);

        // Botões de ação
        HBox botoes = new HBox(10);
        Button btnCadastrar = new Button("Cadastrar");
        Button btnAtualizar = new Button("Atualizar");
        Button btnRemover = new Button("Remover");
        Button btnListar = new Button("Listar");

        botoes.getChildren().addAll(btnCadastrar, btnAtualizar, btnRemover, btnListar);

        // Tabela de livros
        tabelaLivros = new TableView<>();
        configurarTabela();

        // Ações dos botões
        btnCadastrar.setOnAction(e -> {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            Integer ano = Integer.parseInt(txtAno.getText());
            String genero = txtGenero.getText();

            livroController.cadastrarLivro(titulo, autor, ano, genero);
            atualizarTabela();
            limparFormulario(txtId, txtTitulo, txtAutor, txtAno, txtGenero);
        });

        btnAtualizar.setOnAction(e -> {
            Long id = Long.parseLong(txtId.getText());
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            Integer ano = Integer.parseInt(txtAno.getText());
            String genero = txtGenero.getText();

            livroController.atualizarLivro(id, titulo, autor, ano, genero);
            atualizarTabela();
            limparFormulario(txtId, txtTitulo, txtAutor, txtAno, txtGenero);
        });

        btnRemover.setOnAction(e -> {
            Long id = Long.parseLong(txtId.getText());
            livroController.removerLivro(id);
            atualizarTabela();
            limparFormulario(txtId, txtTitulo, txtAutor, txtAno, txtGenero);
        });

        btnListar.setOnAction(e -> atualizarTabela());

        // Montando layout principal
        layoutPrincipal.getChildren().addAll(formulario, botoes, tabelaLivros);

        // Configuração da cena
        Scene scene = new Scene(layoutPrincipal, 800, 600);
        primaryStage.setTitle("Gerenciador de Livros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configurarTabela() {
        TableColumn<Livro, Long> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Livro, String> colunaTitulo = new TableColumn<>("Título");
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        TableColumn<Livro, String> colunaAutor = new TableColumn<>("Autor");
        colunaAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));

        TableColumn<Livro, Integer> colunaAno = new TableColumn<>("Ano");
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));

        TableColumn<Livro, String> colunaGenero = new TableColumn<>("Gênero");
        colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));

        tabelaLivros.getColumns().addAll(colunaId, colunaTitulo, colunaAutor, colunaAno, colunaGenero);
        livros = FXCollections.observableArrayList();
        tabelaLivros.setItems(livros);
    }

    private void atualizarTabela() {
        livros.clear();
        livros.addAll(livroController.listarLivros());
    }

    private void limparFormulario(TextField... campos) {
        for (TextField campo : campos) {
            campo.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
