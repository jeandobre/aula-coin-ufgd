package composite;

public class TrechoComposto implements TrechoAereo {
    private TrechoAereo primeiroTreixo;
    private TrechoAereo segundoTreixo;
    private double taxaConexao;

    public TrechoComposto(TrechoAereo primeiroTreixo, TrechoAereo segundoTreixo, double taxaConexao) {
        this.primeiroTreixo = primeiroTreixo;
        this.segundoTreixo = segundoTreixo;
        this.taxaConexao = taxaConexao;

        if(!primeiroTreixo.destino().equals(segundoTreixo.origem())){
            throw new RuntimeException("O destino do primeiro não é igual a origem do segundo!");
        }
    }

    @Override
    public String origem() {
        return primeiroTreixo.origem();
    }

    @Override
    public String destino() {
        return segundoTreixo.destino();
    }

    @Override
    public double preco() {
        return primeiroTreixo.preco() + segundoTreixo.preco() + taxaConexao;
    }
}
