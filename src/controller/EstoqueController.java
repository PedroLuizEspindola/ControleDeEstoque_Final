package controller;
import java.util.List;
import model.EstoqueModel;
import view.EstoqueView;
import model.Produto;
public class EstoqueController {
    private EstoqueModel model;
    private EstoqueView view;
    
    public EstoqueController(EstoqueModel model, EstoqueView view) {
        this.model = model;
        this.view = view;
    }
    
    public void adicionarProduto(String nomeProduto, int quantidade) {
        Produto produto = new Produto(nomeProduto, quantidade);
        model.adicionarProduto(nomeProduto,quantidade);
    }
    
    public void displayProducts() {
        List<Produto> produtos = model.getProdutos();
        view.mostrarProdutos(produtos);
    }
}
