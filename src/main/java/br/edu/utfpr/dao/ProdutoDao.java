package br.edu.utfpr.dao;

import br.edu.utfpr.model.Produto;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDao extends GenericDao<Produto> {

    public ProdutoDao(EntityManager em) {
        super(em, Produto.class);
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorCategoria(Long categoriaId) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.id = :categoriaId";
        return em.createQuery(jpql, Produto.class)
                .setParameter("categoriaId", categoriaId)
                .getResultList();
    }
}
