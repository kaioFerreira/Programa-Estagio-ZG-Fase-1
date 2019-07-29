package View;

import Controller.PromocaoLevouGanhouController;
import ModeloItem.ItemPromocaoLevouGanhou;

public class PromocaoLevouGanhou {
    
    public static void main(String[] args) {
        //PromocaoLevouGanhou.removerPromocao("Produto L");
        PromocaoLevouGanhou.adicionarPromocao("Produto A", 2, 4, 1);
    }
    public static void adicionarPromocao(String nomePromocao,int produtoRelacionado, int quantidadeLeva, int quantidadeGanha){
        ItemPromocaoLevouGanhou promocao = new ItemPromocaoLevouGanhou();
        
        promocao.setNomePromocao(nomePromocao);
        promocao.setProdutoRelacionado(produtoRelacionado);
        promocao.setQuantidadeLeva(quantidadeLeva);
        promocao.setQuantidadePaga(quantidadeGanha);
        
        PromocaoLevouGanhouController.adicionaPromocao(promocao);
    }
    public static void removerPromocao(String nomePromocao ){
        PromocaoLevouGanhouController.removerPromocao(nomePromocao);
    }
}
