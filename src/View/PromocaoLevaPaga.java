package View;

import Controller.PromocaoLevaPagaController;
import ModeloItem.ItemPromocaoLevaPaga;

public class PromocaoLevaPaga {
    public static void main(String[] args) {
        PromocaoLevaPaga.adicionarPromocao("Produto A",2, 4, 15.0);
        //PromocaoLevaPaga.removerPromocao("Produto L");
        
    }

    public static void adicionarPromocao(String nomePromocao,int produtoRelacionado, int quantidadeLeva, Double valorPaga){
        ItemPromocaoLevaPaga promocao = new ItemPromocaoLevaPaga();
        
        promocao.setNomePromocao(nomePromocao);
        promocao.setProdutoRelacionado(produtoRelacionado);
        promocao.setQuantidadeLeva(quantidadeLeva);
        promocao.setValorPaga(valorPaga);
        
        PromocaoLevaPagaController.adicionaPromocao(promocao);
    }
    
    public static void removerPromocao(String nomePromocao ){
        PromocaoLevaPagaController.removerPromocao(nomePromocao);
    }
}


