package view;
import controller.EstoqueController;
import model.Produto;
import view.EstoqueView;

import java.util.List;
import java.util.Scanner;
import model.EstoqueModel;
public class Main extends EstoqueView{

	public static void main(String[] args) {
		EstoqueModel controller = new EstoqueModel("estoque.txt");
        EstoqueView view = new EstoqueView();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("===== Controle de Estoque =====");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Atualizar quantidade");            
            System.out.println("3. Estoque arquivado");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = scanner.nextLine();
                    System.out.println("Digite a quantidade:");
                    int quantidadeProduto = scanner.nextInt();                    
                    controller.adicionarProduto(nomeProduto,quantidadeProduto );
                    System.out.println("Produto adicionado com sucesso!");  
                    break;               
                case 2:
                    System.out.println("Digite o nome do produto a ser atualizado:");
                    String produtoNome = scanner.nextLine();
                    System.out.println("adicione a nova quantidade:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); 
                    controller.atualizarQuantidade(produtoNome, quantidade);
                    break;
                case 3:
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


