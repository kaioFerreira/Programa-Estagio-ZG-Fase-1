package Controller;

import Model.EstoqueModel;
import Model.PromocaoLevaPagaModel;
import ModeloItem.ItemPromocaoLevaPaga;

public class PromocaoLevaPagaController {
    public static void adicionaPromocao(ItemPromocaoLevaPaga promocao) {
        String verificaExisteEstoque = PromocaoLevaPagaModel.verificaExisteEstoque(promocao.getProdutoRelacionado());
        
        if(verificaExisteEstoque != null) {
             PromocaoLevaPagaModel.adicionaPromocaoBanco(promocao);
        }else{
            System.out.println("Produto Não Existe no Estoque.");
        }
    }
    public static void removerPromocao(String nomePromocao) {
        String verificaExistePromocao = PromocaoLevaPagaModel.verificaExistePromocao(nomePromocao);
        
        if(verificaExistePromocao != null) {
           PromocaoLevaPagaModel.removePromocaoBanco(verificaExistePromocao);
        }else{
            System.out.println("Promocao Não Existe.");
        }
    }   
}
