package Teste;

import View.Caixa;
import View.Distribuidora;
import View.Estoque;
import View.PromocaoLevaPaga;
import View.PromocaoLevouGanhou;

public class TestaPrograma {
    
    public static void main(String[] args) {
        Teste1();
    }
    
    public static void Teste1(){
        Distribuidora.adicionarDistribuidora("Atacadas Limitada", "9999-9999", "atacado#atacado.com.br");
        Estoque.cadastrarProdutoEstoque("A",24.0, 50.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("B",17.0, 30.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("C",12.0, 20.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("D",8.0, 15.0, 10, 1);
        
        
        PromocaoLevaPaga.adicionarPromocao("Promoção A 3 por 130", 1, 3, 130.0);
        PromocaoLevaPaga.adicionarPromocao("Promoção B 2 por 45", 2, 3, 130.0);
        PromocaoLevouGanhou.adicionarPromocao("Promoção C leve 3, pague 2", 3, 3, 2);
        
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.add("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        Caixa.remove("A");
        System.out.println(Caixa.getTotalPrice());
        System.out.println(Caixa.getTotalDiscount());
        
    }
}
