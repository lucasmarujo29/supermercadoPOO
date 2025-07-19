package hierarquia;

import java.util.ArrayList;

public class Compra {
    private int id;
    private Cliente cliente;
    private String dataHora;
    private ArrayList<ItemCompra> itens;
    private double valorTotal;
    private FormaPagamento formaPagamento;

    public Compra(int id, Cliente cliente, String dataHora, ArrayList<ItemCompra> itens, FormaPagamento formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.itens = itens;
        this.formaPagamento = formaPagamento;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemCompra item : itens) {
            valorTotal += item.getPreco();
        }
    }

    public int getId() {
        return id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void adicionarItem(ItemCompra item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(ItemCompra item) {
        itens.remove(item);
        calcularValorTotal();
    }

    public boolean finalizar() {
        //verificar se o cliente possui saldo e todos os itens estao no estoque
        //se ambos sao verdade, realizar as diminuicoes no estoque e no saldo
        boolean statusEstoque = true;
        for(ItemCompra item : itens){
            Produto produto = item.getProduto();
            int qt = item.getQuantidade();
            if(produto.getQuantidadeEstoque() < qt){
                statusEstoque = false;
            }
        }
        boolean statusSaldo = true;
        if(cliente.getSaldo() < valorTotal){
            statusSaldo = false;
        }
        if(statusEstoque && statusSaldo){
            for(ItemCompra item : itens){
                Produto produto = item.getProduto();
                int qt = item.getQuantidade();
                produto.reduzirEstoque(qt);
            }
            cliente.removerSaldo(valorTotal);
        }
        return statusEstoque && statusSaldo;
    }
}
