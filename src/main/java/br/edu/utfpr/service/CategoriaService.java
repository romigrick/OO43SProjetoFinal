package br.edu.utfpr.service;

import br.edu.utfpr.dao.CategoriaDao;
import br.edu.utfpr.model.Categoria;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

public class CategoriaService {
    private EntityManager em;
    private CategoriaDao categoriaDao;

    public CategoriaService(EntityManager em) {
        this.em = em;
        this.categoriaDao = new CategoriaDao(em);
    }

    public void cadastrarCategoria() {
        System.out.print("Digite o nome da categoria: ");
        String nome = new Scanner(System.in).nextLine();
        Categoria categoria = new Categoria(nome);
        categoriaDao.cadastrar(categoria);
        System.out.println("Categoria cadastrada com sucesso!");
    }

    public void alterarCategoria() {
        System.out.print("Digite o ID da categoria a ser alterada: ");
        Long id = new Scanner(System.in).nextLong();
        Categoria categoria = categoriaDao.buscarPorId(id);
        if (categoria != null) {
            System.out.print("Digite o novo nome da categoria: ");
            categoria.setNome(new Scanner(System.in).nextLine());
            categoriaDao.alterar(categoria);
            System.out.println("Categoria alterada com sucesso!");
        } else {
            System.out.println("Categoria não encontrada!");
        }
    }

    public void excluirCategoria() {
        System.out.print("Digite o ID da categoria a ser excluída: ");
        Long id = new Scanner(System.in).nextLong();
        Categoria categoria = categoriaDao.buscarPorId(id);
        if (categoria != null) {
            categoriaDao.excluir(categoria);
            System.out.println("Categoria excluída com sucesso!");
        } else {
            System.out.println("Categoria não encontrada!");
        }
    }

    public void consultarCategoria() {
        System.out.print("Digite o ID da categoria: ");
        Long id = new Scanner(System.in).nextLong();
        Categoria categoria = categoriaDao.buscarPorId(id);
        if (categoria != null) {
            System.out.println(categoria);
        } else {
            System.out.println("Categoria não encontrada!");
        }
    }

    public void listarCategorias() {
        List<Categoria> categorias = categoriaDao.buscarTodos();
        categorias.forEach(System.out::println);
    }
}
