package br.edu.utfpr.service;

import br.edu.utfpr.dao.CategoriaDao;
import br.edu.utfpr.dao.ProdutoDao;
import br.edu.utfpr.dao.EstoqueDao;
import br.edu.utfpr.model.Produto;
import br.edu.utfpr.model.Estoque;
import br.edu.utfpr.model.Categoria;

import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    private EntityManager em;
    private ProdutoDao produtoDao;
    private EstoqueService estoqueService;

    public ProdutoService(EntityManager em) {
        this.em = em;
        this.produtoDao = new ProdutoDao(em);
        this.estoqueService = new EstoqueService(em);
    }

    public void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = new Scanner(System.in).nextLine();
        System.out.print("Digite o preço do produto: ");
        BigDecimal preco = new Scanner(System.in).nextBigDecimal();
        System.out.print("Digite o ID da categoria: ");
        Long categoriaId = new Scanner(System.in).nextLong();

        Categoria categoria = new CategoriaDao(em).buscarPorId(categoriaId);
        if (categoria != null) {
            Produto produto = new Produto(nome, descricao, preco, categoria);
            produtoDao.cadastrar(produto);

            System.out.print("Digite a quantidade em estoque: ");
            int quantidade = new Scanner(System.in).nextInt();

            Estoque estoque = new Estoque(produto, quantidade);
            new EstoqueDao(em).cadastrar(estoque);

            System.out.println("Produto e estoque cadastrados com sucesso!");
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }

    public void alterarProduto() {
        System.out.print("Digite o ID do produto a ser alterado: ");
        Long id = new Scanner(System.in).nextLong();
        Produto produto = produtoDao.buscarPorId(id);
        if (produto != null) {
            System.out.print("Digite o novo nome do produto: ");
            produto.setNome(new Scanner(System.in).nextLine());
            System.out.print("Digite a nova descrição do produto: ");
            produto.setDescricao(new Scanner(System.in).nextLine());
            System.out.print("Digite o novo preço do produto: ");
            produto.setPreco(new Scanner(System.in).nextBigDecimal());
            produtoDao.alterar(produto);
            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void definirQuantidadeProduto() {
        System.out.print("Digite o ID do produto: ");
        Long id = new Scanner(System.in).nextLong();
        Produto produto = produtoDao.buscarPorId(id);
        if (produto != null) {
            System.out.print("Digite a nova quantidade: ");
            int quantidade = new Scanner(System.in).nextInt();
            estoqueService.definirQuantidade(produto, quantidade);
            System.out.println("Quantidade definida com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void excluirProduto() {
        System.out.print("Digite o ID do produto a ser excluído: ");
        Long id = new Scanner(System.in).nextLong();
        Produto produto = produtoDao.buscarPorId(id);
        if (produto != null) {
            produtoDao.excluir(produto);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void consultarProdutoPorId() {
        System.out.print("Digite o ID do produto: ");
        Long id = new Scanner(System.in).nextLong();
        Produto produto = produtoDao.buscarPorId(id);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void consultarProdutoPorNome() {
        System.out.print("Digite o nome do produto: ");
        String nome = new Scanner(System.in).nextLine();
        List<Produto> produtos = produtoDao.buscarPorNome(nome);
        if (!produtos.isEmpty()) {
            produtos.forEach(System.out::println);
        } else {
            System.out.println("Nenhum produto encontrado com esse nome.");
        }
    }

    public void consultarProdutoPorCategoria() {
        System.out.print("Digite o ID da categoria: ");
        Long categoriaId = new Scanner(System.in).nextLong();
        List<Produto> produtos = produtoDao.buscarPorCategoria(categoriaId);
        if (!produtos.isEmpty()) {
            produtos.forEach(System.out::println);
        } else {
            System.out.println("Nenhum produto encontrado nessa categoria.");
        }
    }
}
