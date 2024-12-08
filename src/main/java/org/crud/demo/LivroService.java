package org.crud.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LivroService {

    public void cadastrarLivro(Livro livro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrosPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
        em.close();
    }
    public void atualizarLivro(Livro livro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrosPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
        em.close();
    }
    public void excluirLivro(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrosPU");
        EntityManager em = emf.createEntityManager();
        Livro livro = em.find(Livro.class, id);
        em.getTransaction().begin();
        em.remove(livro);
        em.getTransaction().commit();
        em.close();
    }
    public List<Livro> listarLivros() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrosPU");
        EntityManager em = emf.createEntityManager();
        List<Livro> livros = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
        em.close();
        return livros;
    }


}
