package builder;

import bridge.GeradorArquivo;
import bridge.PosProcessador;

public class BuilderGerador {
    private GeradorArquivo instancia;

    public BuilderGerador gerandoEmXML() {
        //instancia = new GeradorXML();
        return this;
    }

    public BuilderGerador gerandoEmPropriedades(){
      //  instancia = new GeradorPropriedades();
        return this;
    }

    private void adicionaProcessador(PosProcessador p){
        //PosProcessador atual = instancia.
    }

    public GeradorArquivo construir(){
        return instancia;
    }
}
