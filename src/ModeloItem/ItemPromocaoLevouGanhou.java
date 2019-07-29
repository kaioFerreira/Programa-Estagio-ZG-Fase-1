package ModeloItem;

public class ItemPromocaoLevouGanhou {
    private String nomePromocao;
    private int produtoRelacionado;
    private int quantidadeLeva;
    private int quantidadePaga;

    public int getProdutoRelacionado() {
        return produtoRelacionado;
    }
    
    public void setProdutoRelacionado(int produtoRelacionado) {
        this.produtoRelacionado = produtoRelacionado;
    }

    public int getQuantidadeLeva() {
        return quantidadeLeva;
    }

    public void setQuantidadeLeva(int quantidadeLeva) {
        this.quantidadeLeva = quantidadeLeva;
    }

    public int getQuantidadePaga() {
        return quantidadePaga;
    }

    public void setQuantidadePaga(int quantidadePaga) {
        this.quantidadePaga = quantidadePaga;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }
}
