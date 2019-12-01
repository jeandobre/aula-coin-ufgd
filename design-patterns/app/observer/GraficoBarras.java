package observer;

import javax.swing.*;
import java.util.Observable;

public class GraficoBarras implements Observador {

    private JFrame frame = new JFrame();

    @Override
    public void mudancaQuantidade(String acao, int quantidade) {
        System.out.printf("Carteira de ações: " + acao);
        System.out.println(", Quantidade: " + quantidade);
    }
}
