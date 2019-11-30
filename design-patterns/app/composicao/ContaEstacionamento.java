package composicao;

public class ContaEstacionamento {
    private CalculoValor calculo;
    private Veiculo veiculo;

    private long inicio;
    private long fim;

    public double valorConta(){
        return calculo.calcular(inicio - fim);
    }
}
