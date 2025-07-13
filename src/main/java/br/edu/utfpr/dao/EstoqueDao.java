package br.edu.utfpr.dao;

import br.edu.utfpr.model.Estoque;

import jakarta.persistence.EntityManager;

public class EstoqueDao extends GenericDao<Estoque> {

    public EstoqueDao(EntityManager em) {
        super(em, Estoque.class);
    }

    public Estoque buscarPorProduto(Long produtoId) {
        String jpql = "SELECT e FROM Estoque e WHERE e.produto.id = :produtoId";
        return em.createQuery(jpql, Estoque.class)
                .setParameter("produtoId", produtoId)
                .getSingleResult();
    }
}
