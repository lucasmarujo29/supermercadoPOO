package hierarquia;

public class Produto {
    private int id;
    private String nome;
    private Categoria categoria;
    private double precoUnitario; // Preço por unidade do produto, quilo ou litro
    private int quantidadeEstoque; // Quantidade disponível em estoque

    public Produto(int id, String nome, Categoria categoria, double precoUnitario, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", precoUnitario=" + precoUnitario +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
    public double calcularPrecoTotal(int quantidade) {
        return precoUnitario * quantidade;
    }

    public boolean verificarDisponibilidade(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }

    public void reduzirEstoque(int quantidade) {
        if (verificarDisponibilidade(quantidade)) {
            quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade solicitada não disponível em estoque.");
        }
    }

    
    
}
