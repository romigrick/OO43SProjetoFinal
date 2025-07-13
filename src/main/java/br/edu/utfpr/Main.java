package br.edu.utfpr;

import br.edu.utfpr.service.CategoriaService;
import br.edu.utfpr.service.ProdutoService;
import br.edu.utfpr.service.EstoqueService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EntityManager em;
    private static CategoriaService categoriaService;
    private static ProdutoService produtoService;
    private static EstoqueService estoqueService;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();

        categoriaService = new CategoriaService(em);
        produtoService = new ProdutoService(em);
        estoqueService = new EstoqueService(em);

        while (true) {
            exibirMenu();

            int opcao = obterOpcaoValida();

            switch (opcao) {
                case 1:
                    estoqueService.registrarSaida();
                    break;
                case 2:
                    estoqueService.registrarEntrada();
                    break;
                case 3:
                    estoqueService.listarQuantidades();
                    break;
                case 4:
                    estoqueService.listarQuantidadeProduto();
                    break;
                case 5:
                    estoqueService.listarValorTotalProduto();
                    break;
                case 6:
                    estoqueService.listarValorTotalCategoria();
                    break;
                case 7:
                    estoqueService.listarValorTotalEstoque();
                    break;
                case 8:
                    exibirSubMenuCategorias();
                    break;
                case 9:
                    exibirSubMenuProdutos();
                    break;
                case 99:
                    estoqueService.limparEstoque();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    em.close();
                    emf.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static int obterOpcaoValida() {
        while (true) {
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao < 0) {
                    System.out.print("Insira um valor válido...\n\nEscolha uma Opção: ");
                    continue;
                }

                if (opcao >= 0 && opcao <= 99) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida! Escolha uma das opções disponíveis");
                }
            } catch (InputMismatchException e) {
                System.out.print("A entrada precisa ser um valor numérico\n\nEscolha uma Opção: ");
                scanner.nextLine();
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n----- Sistema de Gerenciamento de Estoque v1.0 -----");
        System.out.println("\n");
        System.out.println("===Gerenciamento de Estoque===");
        System.out.println("\n");
        System.out.println("1. Registrar saída de produtos");
        System.out.println("2. Registrar entrada de produtos");
        System.out.println("3. Listar Todos os produtos");
        System.out.println("4. Consultar Quantidade de um Produto");
        System.out.println("5. Listar valor Total por produto");
        System.out.println("6. Listar Valor Total por categoria");
        System.out.println("7. Listar Valor Total armazenado em estoque");
        System.out.println("\n");
        System.out.println("===Menu Administrativo===");
        System.out.println("\n");
        System.out.println("8. Gerenciar  Categorias");
        System.out.println("9. Gerenciar Produtos");
        System.out.println("\n");
        System.out.println("======================RichardsonRomig");
        System.out.println("\n");
        System.out.println("99. Fazer limpeza do estoque (Utilizar somente com certeza total)");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirSubMenuCategorias() {
        System.out.println("===Gerenciamento de Categorias===");
        System.out.println("1. Cadastrar Categoria");
        System.out.println("2. Alterar Categoria");
        System.out.println("3. Excluir Categoria");
        System.out.println("4. Consultar Categoria(ID)");
        System.out.println("5. Listar todas as Categorias");
        System.out.print("Escolha uma opção: ");

        int opcaoCategoria = obterOpcaoValida();

        switch (opcaoCategoria) {
            case 1:
                categoriaService.cadastrarCategoria();
                break;
            case 2:
                categoriaService.alterarCategoria();
                break;
            case 3:
                categoriaService.excluirCategoria();
                break;
            case 4:
                categoriaService.consultarCategoria();
                break;
            case 5:
                categoriaService.listarCategorias();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void exibirSubMenuProdutos() {
        System.out.println("===Gerenciamento de Produtos===");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Definir quantidade do Produto");
        System.out.println("4. Excluir Produto");
        System.out.println("5. Consultar Produto por ID");
        System.out.println("6. Consultar Produtos por Nome");
        System.out.println("7. Consultar Produtos por Categoria");
        System.out.print("Escolha uma opção: ");

        int opcaoProduto = obterOpcaoValida();

        switch (opcaoProduto) {
            case 1:
                produtoService.cadastrarProduto();
                break;
            case 2:
                produtoService.alterarProduto();
                break;
            case 3:
                produtoService.definirQuantidadeProduto();
                break;
            case 4:
                produtoService.excluirProduto();
                break;
            case 5:
                produtoService.consultarProdutoPorId();
                break;
            case 6:
                produtoService.consultarProdutoPorNome();
                break;
            case 7:
                produtoService.consultarProdutoPorCategoria();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
