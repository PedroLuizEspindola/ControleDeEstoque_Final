package model;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import model.Produto;
	import view.EstoqueView;
	public class EstoqueModel {
		private String ARQUIVO_ESTOQUE = "c:/Temp/ws-eclipse/estoque.txt";
	    
	    public EstoqueModel(String ARQUIVO_ESTOQUE) {
	        this.ARQUIVO_ESTOQUE = ARQUIVO_ESTOQUE;
	    }   
	               
	    
	    // Método para adicionar um produto ao estoque
	    public void adicionarProduto(String nomeProduto, int quantidade) {
	    	Produto produto = new Produto(nomeProduto,quantidade);
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE, true))) {
	            writer.write(produto.getNome());
	            writer.newLine();
	            writer.write(String.valueOf(produto.getQuantidade()));
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
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
	    
	    // Método para obter a lista de produtos do estoque
	    public List<Produto> getProdutos(){
	        List<Produto> produtos = new ArrayList<>();
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String nome = line;
	                int quantidade = Integer.parseInt(reader.readLine());
	                Produto produto = new Produto(nome, quantidade);
	                produtos.add(produto);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return produtos;
	    }
	    public void atualizarQuantidade(String produtoNome, int quantidade) {
	        List<Produto> produtos = getProdutos();
	        boolean found = false;
	        for (int i = 0; i < produtos.size(); i++) {
	            Produto produto = produtos.get(i);
	            if (produto.getNome().equals(produtoNome)) {
	                int updatedQuantidade = produto.getQuantidade() + quantidade;
	                produto = new Produto(produtoNome, updatedQuantidade);
	                produtos.set(i, produto);
	                found = true;
	                break;
	            }
	       
	            
	        }
	        if(!found) {
	        	System.out.println("Produto inexistente, adicione o produto antes de fazer alteracoes");		
	        }
	        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
	            for (Produto produto : produtos) {
	                writer.write(produto.getNome());
	                writer.newLine();
	                writer.write(String.valueOf(produto.getQuantidade()));
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
