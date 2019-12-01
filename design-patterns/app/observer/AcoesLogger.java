package observer;

public class AcoesLogger implements Observador {

    @Override
    public void mudancaQuantidade(String acao, int quantidade) {
        System.out.println("Alterada a quantidade da ação " +
                acao + " para " + quantidade);
    }
}
