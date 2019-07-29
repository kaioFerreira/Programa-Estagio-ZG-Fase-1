package ModeloItem;

public class ItemPromocaoLevaPaga {
    private String nomePromocao;
    private int produtoRelacionado;
    private int quantidadeLeva;
    private Double valorPaga;

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

    public Double getValorPaga() {
        return valorPaga;
    }

    public void setValorPaga(Double valorPaga) {
        this.valorPaga = valorPaga;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }
}
