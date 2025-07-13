package br.edu.utfpr.service;

import br.edu.utfpr.dao.EstoqueDao;
import br.edu.utfpr.dao.ProdutoDao;
import br.edu.utfpr.model.Estoque;
import br.edu.utfpr.model.Produto;

import jakarta.persistence.EntityManager;

import java.math.*;
import java.util.List;
import java.util.Scanner;

public class EstoqueService {
    private EntityManager em;
    private EstoqueDao estoqueDao;

    public EstoqueService(EntityManager em) {
        this.em = em;
        this.estoqueDao = new EstoqueDao(em);
    }

    public void listarQuantidades() {
        List<Estoque> estoques = estoqueDao.buscarTodos();
        estoques.forEach(estoque -> System.out.println(estoque.getProduto().getNome() + " - Quantidade: " + estoque.getQuantidade() + " - ID: " + estoque.getProduto().getId()));
    }

    public void listarValorTotalProduto() {
        System.out.print("Digite o ID do produto: ");
        Long produtoId = new Scanner(System.in).nextLong();
        BigDecimal valorTotal = listarValorTotalProdutoPorId(produtoId);
        System.out.println("Valor total do produto no estoque: R$" + valorTotal);
    }

    private BigDecimal listarValorTotalProdutoPorId(Long produtoId) {
        Produto produto = new ProdutoDao(em).buscarPorId(produtoId);
        if (produto != null) {
            Estoque estoque = estoqueDao.buscarPorProduto(produtoId);
            if (estoque != null) {
                return produto.getPreco().multiply(new BigDecimal(estoque.getQuantidade()));
            }
        }
        return BigDecimal.ZERO;
    }

    public int listarQuantidadeProdutoPorId(Long produtoId) {

        Produto produto = new ProdutoDao(em).buscarPorId(produtoId);
        if (produto != null) {
            Estoque estoque = estoqueDao.buscarPorProduto(produtoId);
            if (estoque != null) {
                return estoque.getQuantidade();
            }
        }
        return 0;
    }

    public void listarQuantidadeProduto() {
        System.out.print("Digite o ID do produto: ");
        Long produtoId = new Scanner(System.in).nextLong();
        int quantidade = listarQuantidadeProdutoPorId(produtoId);
        System.out.println("Quantidade do produto no estoque: " + quantidade);
    }

    public void listarValorTotalCategoria() {
        System.out.print("Digite o ID da categoria: ");
        Long categoriaId = new Scanner(System.in).nextLong();
        BigDecimal total = BigDecimal.ZERO;
        List<Produto> produtos = new ProdutoDao(em).buscarPorCategoria(categoriaId);
        for (Produto produto : produtos) {
            total = total.add(listarValorTotalProdutoPorId(produto.getId()));
        }
        System.out.println("Valor total da categoria no estoque: R$" + total);
    }

    public void listarValorTotalEstoque() {
        List<Estoque> estoques = estoqueDao.buscarTodos();
        BigDecimal total = BigDecimal.ZERO;
        for (Estoque estoque : estoques) {
            total = total.add(estoque.getProduto().getPreco().multiply(new BigDecimal(estoque.getQuantidade())));
        }
        System.out.println("Valor total armazenado no estoque: R$" + total);
    }

    public void limparEstoque() {
        List<Estoque> estoques = estoqueDao.buscarTodos();
        for (Estoque estoque : estoques) {
            estoque.setQuantidade(0);
            estoqueDao.alterar(estoque);
        }
        System.out.println("Estoque limpo com sucesso!");
    }

    public void definirQuantidade(Produto produto, int quantidade) {
        Estoque estoque = estoqueDao.buscarPorProduto(produto.getId());
        if (estoque == null) {
            estoque = new Estoque(produto, quantidade);
            estoqueDao.cadastrar(estoque);
        } else {
            estoque.setQuantidade(quantidade);
            estoqueDao.alterar(estoque);
        }
    }

    public void registrarEntrada() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do produto para entrada: ");
        Long produtoId = scanner.nextLong();
        System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new ProdutoDao(em).buscarPorId(produtoId);

        if (produto != null) {
            Estoque estoque = estoqueDao.buscarPorProduto(produtoId);
            if (estoque != null) {
                estoque.setQuantidade(estoque.getQuantidade() + quantidade);
                estoqueDao.alterar(estoque);
                System.out.println("Entrada registrada com sucesso! Novo estoque de " + produto.getNome() + ": " + estoque.getQuantidade());
            } else {
                Estoque novoEstoque = new Estoque(produto, quantidade);
                estoqueDao.cadastrar(novoEstoque);
                System.out.println("Entrada registrada com sucesso! Novo estoque de " + produto.getNome() + ": " + novoEstoque.getQuantidade());
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void registrarSaida() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do produto para saída: ");
        Long produtoId = scanner.nextLong();
        System.out.print("Digite a quantidade a ser removida do estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new ProdutoDao(em).buscarPorId(produtoId);

        if (produto != null) {
            Estoque estoque = estoqueDao.buscarPorProduto(produtoId);
            if (estoque != null) {
                if (estoque.getQuantidade() >= quantidade) {
                    estoque.setQuantidade(estoque.getQuantidade() - quantidade);
                    estoqueDao.alterar(estoque);
                    System.out.println("Saída registrada com sucesso! Novo estoque de " + produto.getNome() + ": " + estoque.getQuantidade());
                } else {
                    System.out.println("Quantidade insuficiente no estoque para a saída.");
                }
            } else {
                System.out.println("Produto não encontrado no estoque.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
