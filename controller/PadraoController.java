package controller;

import java.util.List;

import model.Produto;

public interface PadraoController {
	
	public void adicionarProduto(String nome,int quantidade);
	
	public void exibirArquivoEstoque();
	
	public List<Produto> getProdutos();
	
	public void atualizarQuantidade(String produtoNome, int quantidade);
}
