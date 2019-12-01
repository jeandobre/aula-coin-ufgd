package state;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No {
    private Set<No> adjacentes = new HashSet<>();
    private Cor cor;
    private String nome;

    public No(String nome) {
        this.nome = nome;
        this.cor = new Branco();
    }

    public void buscarProfundidade(List<No> lista){
        cor.busca(this, lista);
    }

    public Set<No> getAdjacentes(){
        return adjacentes;
    }

    public void addAdjacentes(No adjacente){
        adjacentes.add(adjacente);
    }

    public void setCor(Cor cor, List<No> lista){
        this.cor = cor;
        cor.assumiu(this, lista);
    }

    @Override
    public String toString() {
        return nome;
    }
}
