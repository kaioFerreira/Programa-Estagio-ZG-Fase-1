package Controller;

import Model.PromocaoLevaPagaModel;
import Model.PromocaoLevouGanhouModel;
import ModeloItem.ItemPromocaoLevouGanhou;

public class PromocaoLevouGanhouController {
    public static void adicionaPromocao(ItemPromocaoLevouGanhou promocao) {
        String verificaExisteEstoque = PromocaoLevaPagaModel.verificaExisteEstoque(promocao.getProdutoRelacionado());
        
        if(verificaExisteEstoque != null) {
             PromocaoLevouGanhouModel.adicionaPromocaoBanco(promocao);
        }else{
            System.out.println("Produto Não Existe no Estoque.");
        }
    }
    public static void removerPromocao(String nomePromocao) {
        String verificaExistePromocao = PromocaoLevouGanhouModel.verificaExistePromocao(nomePromocao);
        
        if(verificaExistePromocao != null) {
           PromocaoLevouGanhouModel.removePromocaoBanco(verificaExistePromocao);
        }else{
            System.out.println("Promocao Não Existe.");
        }
    }
}
