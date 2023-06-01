package view;

import java.util.List;

import model.Produto; 
public class EstoqueView {
    public void exibirProdutos(List<Produto> produtos) {
        System.out.println("Estoque:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());          
            System.out.println("--------------------");
        }
    }
}

