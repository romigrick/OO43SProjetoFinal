package br.edu.utfpr.dao;

import br.edu.utfpr.model.Categoria;

import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao extends GenericDao<Categoria> {

    public CategoriaDao(EntityManager em) {
        super(em, Categoria.class);
    }

    public List<Categoria> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Categoria c WHERE c.nome = :nome";
        return em.createQuery(jpql, Categoria.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
