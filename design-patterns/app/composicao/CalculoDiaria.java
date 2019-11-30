package composicao;

public class CalculoDiaria implements CalculoValor {
    private double valorDiaria;
    private final static double HORA = 1;

    @Override
    public void calcular(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double calcular(long periodo, Veiculo veiculo){
        return valorDiaria * Math.ceil(periodo / HORA);
    }
}
