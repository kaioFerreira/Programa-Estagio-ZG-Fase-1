package View;

import Controller.DistribuidoraController;
import ModeloItem.ItemDistribuidora;

public class Distribuidora {
    public static void adicionarDistribuidora(String nome, String telefone, String email){
        ItemDistribuidora itemDistribuidora = new ItemDistribuidora();
        
        itemDistribuidora.setNome(nome);
        itemDistribuidora.setTelefone(telefone);
        itemDistribuidora.setEmail(email);
        DistribuidoraController.adicionaBanco(itemDistribuidora);
    } 
}
