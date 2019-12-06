package mediator;

import observer.CarteiraAcoes;
import observer.Observador;

import java.util.ArrayList;
import java.util.List;

public class GrupoObservacao implements Observador {
    private List<Observador> obs = new ArrayList<>();

    @Override
    public void mudancaQuantidade(String acao, int quantidade) {
        for(Observador o: obs)
            o.mudancaQuantidade(acao, quantidade);
    }

    public void addObservador(Observador o){
        obs.add(o);
    }

    public void addCarteira(CarteiraAcoes ca){
        ca.addObservador(this);
    }
}
