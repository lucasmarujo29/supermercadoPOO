package hierarquia;

public class ItemCompra {
    private Produto produto;
    private int quantidade;
    private double preco;

    public ItemCompra(Produto produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemCompra(Produto produto, int quantidade) {
        this(produto, quantidade, produto.calcularPrecoTotal(quantidade));
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        preco = produto.calcularPrecoTotal(quantidade);
    }

    @Override
    public String toString() {
        return "ItemCompra{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

}
