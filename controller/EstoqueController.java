package controller;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import view.EstoqueView;
public class EstoqueController implements PadraoController {
    private List<Produto> estoque;
    private EstoqueView view;
    private final String ARQUIVO_ESTOQUE = "c:/Temp/ws-eclipse/estoque.txt";
    public Scanner scanner = new Scanner(System.in);
    
    public EstoqueController() {
        this.estoque = new ArrayList<>();
        this.view = new EstoqueView();
    }

    public void adicionarProduto(String nome, int quantidade) {
        Produto produto = new Produto(nome, quantidade);
        estoque.add(produto);
        salvarEstoqueEmArquivo();
    }

    public void removerProduto(String nome) {
        Produto produtoRemover = null;
        for (Produto produto : estoque) {
            if (produto.getNome().equals(nome)) {
                produtoRemover = produto;
                break;
            }
        }

        if (produtoRemover != null) {
            estoque.remove(produtoRemover);
            salvarEstoqueEmArquivo();
            System.out.println("Produto removido: " + produtoRemover.getNome());
        } else {
            System.out.println("Produto não encontrado: " + nome);
        }
    }

        public void atualizarQuantidade(String nome, int novaQuantidade) {
            Produto produtoAtualizar = null;
            for (Produto produto : estoque) {
                if (produto.getNome().equals(nome)) {
                    produtoAtualizar = produto;
                    break;
                }
            }

            if (produtoAtualizar != null) {
                produtoAtualizar.setQuantidade(novaQuantidade);
                salvarEstoqueEmArquivo();
                System.out.println("Quantidade atualizada para o produto: " + produtoAtualizar.getNome());
            } else {
                System.out.println("Produto não encontrado: " + nome);
            }
        }

    public void carregarEstoqueDeArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
            estoque.clear();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String nome = dados[0];
                    int quantidade = Integer.parseInt(dados[1]);
                    double preco = Double.parseDouble(dados[2]);
                    Produto produto = new Produto(nome, quantidade);
                    estoque.add(produto);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque do arquivo: " + e.getMessage());
        }
    }

    public void salvarEstoqueEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Produto produto : estoque) {
                writer.write("nome;" + produto.getNome() + " quantidade;" + produto.getQuantidade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque no arquivo: " + e.getMessage());
        }
    }
    public void exibirArquivoEstoque() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo do estoque: " + e.getMessage());
        }
    }

    public void exibirEstoque() {
        view.exibirProdutos(estoque);
    }
}	


