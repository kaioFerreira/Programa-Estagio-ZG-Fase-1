package Controller;

import Model.CaixaModel;
import Model.PromocaoLevaPagaModel;
import Model.PromocaoLevouGanhouModel;
import ModeloItem.ItemCaixa;
import ModeloItem.ItemPromocaoLevaPaga;
import ModeloItem.ItemPromocaoLevouGanhou;
import View.Estoque;
import java.util.ArrayList;
import java.util.List;

public class CaixaController {
    public static void addCaixa(String nomeProduto) {
        boolean verificaExisteEstoque = CaixaModel.verificaExisteEstoque(nomeProduto);
        String verificaExisteCaixa = CaixaModel.verificaExisteCaixa(nomeProduto);
        
        if(verificaExisteEstoque) {
            if(verificaExisteCaixa == null){
                CaixaModel.addCaixaBanco(nomeProduto);
            } else {
                CaixaModel.addMaisUmCaixaBanco(nomeProduto);
            }
            Estoque.RemoverQuantidadeProduto(nomeProduto,"1");
        }else{
            System.out.println("Produto Não Existe no Estoque ou Esta em Falta.");
        }
    }

    public static void removeCaixa(String nomeProduto) {
        String verificaExisteCaixa = CaixaModel.verificaExisteCaixa(nomeProduto);
        
        if(verificaExisteCaixa != null) {
            CaixaModel.removeCaixaBanco(nomeProduto);
        }else{
            System.out.println("Produto Não Esta no caixa.");
        }
    }

    public static Double getTotalPriceCaixa() {

        Double resultado = 0.0;
        
        List <ItemCaixa> listaItensCaixa = new ArrayList<>();
        
        listaItensCaixa = CaixaModel.ItensCaixa();
        
        Double valorTotal = 0.0;
        for (ItemCaixa Item : listaItensCaixa) {
            valorTotal+=  Item.getQuantidade() * Item.getValorUnitario();
            resultado += calculaValorItemPromocao(Item.getCodigoProduto(),Item.getQuantidade(),Item.getValorUnitario());
        }
        System.out.println(valorTotal);
        return resultado;
    }
    
    private static Double calculaValorItemPromocao(int codigoProduto, int quantidade, Double valorUnitario) {
        
        List <ItemPromocaoLevaPaga> listaItensPromocaoLevaPaga =  new ArrayList<>();
        listaItensPromocaoLevaPaga = PromocaoLevaPagaModel.itensPromocao();
        
        Double resultadoFinal = 0.0;
        Double resultadoLevaPaga = 0.0;
        int resp = 0;
        int quantidadeLP = quantidade;
        for (ItemPromocaoLevaPaga Item : listaItensPromocaoLevaPaga) {
            if( Item.getProdutoRelacionado() == codigoProduto ){
                resp = quantidadeLP / Item.getQuantidadeLeva();
                if(quantidadeLP < Item.getQuantidadeLeva())break;
                
                if(resp != 0)
                {
                    resultadoLevaPaga += (resp  * Item.getValorPaga() + ((quantidadeLP%Item.getQuantidadeLeva()) * valorUnitario));
                    quantidadeLP-= resp * Item.getQuantidadeLeva();
                }
                
            }
        }
        resultadoLevaPaga+= quantidadeLP * valorUnitario;
        
        List <ItemPromocaoLevouGanhou> listaItensPromocaoLevouGanhou =  new ArrayList<>();
        listaItensPromocaoLevouGanhou = PromocaoLevouGanhouModel.itensPromocao();
        Double resultadoLevouGanhou = 0.0;
        
        int quantidadeLpe = quantidade;
        for (ItemPromocaoLevouGanhou Item : listaItensPromocaoLevouGanhou) {
            if( Item.getProdutoRelacionado() == codigoProduto ){
                resp = quantidadeLpe / Item.getQuantidadeLeva();
                
                if(quantidadeLpe < Item.getQuantidadeLeva())break;
                
                if(resp != 0)
                {
                    resultadoLevouGanhou += (quantidadeLpe * valorUnitario - resp  * valorUnitario);
                    quantidadeLpe-= resp * Item.getQuantidadeLeva();
                }
            }
        }
        quantidadeLpe+= resp * quantidadeLpe;
        if (resultadoLevouGanhou == 0 || resultadoLevaPaga==0)resultadoFinal = resultadoLevouGanhou + resultadoLevaPaga;
        resultadoFinal += resultadoLevouGanhou < resultadoLevaPaga ? resultadoLevouGanhou : resultadoLevaPaga;
        return resultadoFinal;
    }

    public static Double getTotalDiscount() {
        Double resultado = 0.0;
        
        List <ItemCaixa> listaItensCaixa = new ArrayList<>();
        
        listaItensCaixa = CaixaModel.ItensCaixa();
        
        Double valorTotal = 0.0;
        for (ItemCaixa Item : listaItensCaixa) {
            valorTotal+=  Item.getQuantidade() * Item.getValorUnitario();
            resultado += calculaValorItemPromocao(Item.getCodigoProduto(),Item.getQuantidade(),Item.getValorUnitario());
        }
   
        return valorTotal - resultado;
    }
    
}
