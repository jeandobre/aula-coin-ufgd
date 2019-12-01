package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarteiraAcoes {
    private Map<String, Integer> acoes = new HashMap<>();
    private List<Observador> observadores = new ArrayList<>();

    public void adicionaAcoes(String acao, int quantidade){
        if(acoes.containsKey(acao)){
            quantidade += acoes.get(acao);
        }
        acoes.put(acao, quantidade);
        notificar(acao, quantidade);
    }

    private void notificar(String acao, int quantidade){
        for(Observador observador : observadores)
            observador.mudancaQuantidade(acao, quantidade);
    }

    public void addObservador(Observador observador){
        observadores.add(observador);
    }
}
