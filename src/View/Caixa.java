
package View;

import Controller.CaixaController;

public class Caixa {
    public static void add(String nomeProduto){
        CaixaController.addCaixa(nomeProduto);
    }
    
    public static void remove(String nomeProduto){
        CaixaController.removeCaixa(nomeProduto);
    }
    
    public static Double getTotalPrice(){
        return CaixaController.getTotalPriceCaixa();
    }
    
    public static Double getTotalDiscount(){
        return CaixaController.getTotalDiscount();
    } 
}
