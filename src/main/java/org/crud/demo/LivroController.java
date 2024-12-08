package org.crud.demo;

import java.util.ArrayList;
import java.util.List;

public class LivroController {
    LivroService livroService = new LivroService();

    public void cadastrarLivro(String titulo,String autor,Integer anoPublicacao,String genero){
        Livro livroTemp = new Livro(titulo,autor,anoPublicacao,genero);
        livroService.cadastrarLivro(livroTemp);
        System.out.println("Livro Cadastrado!");
    }


    public List<Livro> listarLivros(){
        List<Livro> livrosTemp = new ArrayList<>();
        livrosTemp = livroService.listarLivros();
        System.out.println("Livros Cadastrados: ");
        return livrosTemp;
    }

    public void listarLivrosConsole(){
        List<Livro> livrosTemp = new ArrayList<>();
        livrosTemp = livroService.listarLivros();
        System.out.println("Livros Cadastrados: ");
        for (Livro l : livrosTemp){
            System.out.println(l.toString());
        }
    }
    public void removerLivro(Long id){
        livroService.excluirLivro(id);
        System.out.println("Livro Removido!");
    }

    public void atualizarLivro(Long id,String titulo,String autor,Integer anoPublicacao,String genero){
        Livro livroTemp = new Livro(id,titulo,autor,anoPublicacao,genero);
        livroService.atualizarLivro(livroTemp);
        System.out.println("Livro Atualizado!");
    }

}
