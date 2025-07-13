package br.edu.utfpr.dao;

import jakarta.persistence.*;

import java.util.List;

public abstract class GenericDao<T> {

    protected EntityManager em;
    private Class<T> entityClass;

    public GenericDao(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void cadastrar(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void alterar(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void excluir(T entity) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Buscar entidade por ID
    public T buscarPorId(Long id) {
        return em.find(entityClass, id);
    }

    // Buscar todas as entidades
    public List<T> buscarTodos() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }
}
