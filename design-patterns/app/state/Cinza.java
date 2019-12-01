package state;

import java.util.List;

public class Cinza extends Cor {
    void assumiu(No no, List<No> lista){
        for(No adj: no.getAdjacentes())
            adj.buscarProfundidade(lista);
        no.setCor(new Preto(), lista);
    }
}
