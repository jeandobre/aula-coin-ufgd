package composite;

public class TrechoSimples implements TrechoAereo {
    private String origem;
    private String destino;
    private double preco;

    public TrechoSimples(String origem, String destino, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    @Override
    public String origem() {
        return origem;
    }

    @Override
    public String destino() {
        return destino;
    }

    @Override
    public double preco() {
        return preco;
    }
}
