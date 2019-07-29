package Controller;

import Model.EstoqueModel;
import ModeloItem.ItemEstoque;

public class EstoqueController {

    public static void cadastrarEstoque(ItemEstoque produto){
        EstoqueModel.cadastraProdutoBanco(produto);
    }

    public static void removerEstoque(String nomeProduto) {
        EstoqueModel.removerBanco(nomeProduto);
    }

    public static void alterarNomeEstoque(String nomeProduto, String novoNomeProduto) {
        EstoqueModel.alterarNomeBanco(nomeProduto, novoNomeProduto);
    }

    public static void alterarValorCustoEstoque(String nomeProduto, String novoValorCusto) {
        EstoqueModel.alterarValorCustoBanco(nomeProduto, novoValorCusto);
    }

    public static void alterarValorVendaEstoque(String nomeProduto, String novoValorVenda) {
        EstoqueModel.alterarValorVendaBanco(nomeProduto, novoValorVenda);
    }

    public static String quantidadeNoEstoque(String nomeProduto) {
        return EstoqueModel.quantidadeNoBanco(nomeProduto);
    }

    public static void alterarQuantidadeEstoque(String nomeProduto, String quantidadeFinal) {
        if(Integer.parseInt(quantidadeFinal) < 0)quantidadeFinal = "0";
        EstoqueModel.alterarQuantidadeBanco(nomeProduto, quantidadeFinal);
    }
}
