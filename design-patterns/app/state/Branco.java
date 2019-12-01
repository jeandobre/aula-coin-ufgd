package state;

import java.util.List;

public class Branco extends Cor {
    public void busca(No no, List<No> lista){
        no.setCor(new Cinza(), lista);
    }
}
