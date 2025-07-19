package hierarquia;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private TipoCliente tipoCliente;
    private double saldo;

    public Cliente(int id, String nome, String cpf, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
        this.saldo = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor a adicionar deve ser positivo.");
        }
    }

    public void removerSaldo(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Valor a remover deve ser positivo e não pode exceder o saldo atual.");
        }
    }

    @Override
    public String toString() { 
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", tipoCliente=" + tipoCliente +
                ", saldo=" + saldo +
                '}';
    }

    public boolean verificarSaldoSuficiente(double valor) {
        return saldo >= valor;
    }

}
