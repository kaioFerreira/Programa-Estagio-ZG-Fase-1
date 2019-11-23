package View;
import ModeloItem.ItemEstoque;
import Controller.EstoqueController;

public class Estoque {

    public static void main(String[] args) {
        //Estoque.cadastrarProdutoEstoque("J",10.0,20.0,5,1);
        Estoque.AdicionarQuantidadeProduto("J", "10");
        
    }
    public static void cadastrarProdutoEstoque(String nome, Double valorCusto, Double valorVenda, int quantidade, int idDistribuidora ){
        ItemEstoque produto = new ItemEstoque();
        
        produto.setNome(nome);
        produto.setValorCusto(valorCusto);kaiqueviado
        produto.setValorVenda(valorVenda);
        produto.setQuantidade(quantidade);
        produto.setIdDistribuidora(idDistribuidora);

        EstoqueController.cadastrarEstoque(produto);
    }
    
    public static void removerProdutoEstoque(String nomeProduto){
        EstoqueController.removerEstoque(nomeProduto);
    }
    
    public static void AdicionarQuantidadeProduto(String nomeProduto, String quantidadeAdicional){
        //para remover coloque numeros negativos no quantidade adicional
        String QunatidadeNoEstoque = EstoqueController.quantidadeNoEstoque(nomeProduto);
        String quantidadeFinal = Integer.toString(Integer.parseInt(quantidadeAdicional) + Integer.parseInt(QunatidadeNoEstoque));
        EstoqueController.alterarQuantidadeEstoque(nomeProduto,quantidadeFinal);
    }
    
    public static void RemoverQuantidadeProduto(String nomeProduto, String quantidadeRemover){
        //para remover coloque numeros negativos no quantidade adicional
        String QunatidadeNoEstoque = EstoqueController.quantidadeNoEstoque(nomeProduto);
        String quantidadeFinal = Integer.toString(Integer.parseInt(QunatidadeNoEstoque) - Integer.parseInt(quantidadeRemover));
        EstoqueController.alterarQuantidadeEstoque(nomeProduto,quantidadeFinal);
    }
    
    public static void alterarNomeProduto(String nomeProduto, String novoNomeProduto){
        EstoqueController.alterarNomeEstoque(nomeProduto,novoNomeProduto);
    }
    
    public static void alterarValorCustoProduto(String nomeProduto, String novoValorCusto){
        EstoqueController.alterarValorCustoEstoque(nomeProduto,novoValorCusto);
    }
    
    public static void alterarValorVendaProduto(String nomeProduto, String novoValorVenda){
        EstoqueController.alterarValorVendaEstoque(nomeProduto,novoValorVenda);
    }

}
