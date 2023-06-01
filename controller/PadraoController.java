package controller;

public interface PadraoController {

	public void adicionarProduto(String nome, int quantidade);
	
	public void removerProduto(String nome);
	
	public void atualizarQuantidade(String nome, int novaQuantidade);
	
	public void carregarEstoqueDeArquivo();
	
	public void salvarEstoqueEmArquivo();
	
	public void exibirArquivoEstoque();
}
