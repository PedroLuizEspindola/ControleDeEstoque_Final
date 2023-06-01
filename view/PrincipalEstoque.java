package view;

import java.util.*;
import controller.EstoqueController;

public class PrincipalEstoque {
	public static void main(String[] args) {
		EstoqueController controller = new EstoqueController();
        Scanner scanner = new Scanner(System.in);

        // Carregar o estoque do arquivo
        controller.carregarEstoqueDeArquivo();

        while (true) {
            System.out.println("===== Controle de Estoque =====");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade");
            System.out.println("4. Exibir estoque");
            System.out.println("5. Estoque arquivado");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = scanner.nextLine();
                    System.out.println("Digite a quantidade:");
                    int quantidadeProduto = scanner.nextInt();
                    System.out.println("Digite o preço:");
                    double precoProduto = scanner.nextDouble();
                    scanner.nextLine(); 
                    controller.adicionarProduto(nomeProduto, quantidadeProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do produto a ser removido:");
                    String nomeRemover = scanner.nextLine();
                    controller.removerProduto(nomeRemover);
                    break;
                case 3:
                    System.out.println("Digite o nome do produto a ser atualizado:");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("Digite a nova quantidade:");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine(); 
                    controller.atualizarQuantidade(nomeAtualizar, novaQuantidade);
                    break;
                case 4:
                    System.out.println("Estoque atual:");
                    controller.exibirEstoque();
                    break;
                case 5:
                	System.out.println("Estoque arquivado");
                	controller.exibirArquivoEstoque();
                	break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
	

