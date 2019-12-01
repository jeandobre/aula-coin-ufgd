package state;

import java.util.ArrayList;
import java.util.List;

public class ExecutarBusca {
    public static void main(String[] args){
        No a = new No("A");
        No b = new No("B");
        No c = new No("C");
        No d = new No("D");

        No e = new No("E");
        No f = new No("F");
        No g = new No("G");
        No h = new No("H");

        a.addAdjacentes(b);
        a.addAdjacentes(e);
        a.addAdjacentes(h);

        b.addAdjacentes(c);
        c.addAdjacentes(d);
        d.addAdjacentes(b);
        e.addAdjacentes(f);

        f.addAdjacentes(c);
        f.addAdjacentes(g);
        f.addAdjacentes(h);

        List<No> primeiro = new ArrayList<>();
        a.buscarProfundidade(primeiro);
        for(No no : primeiro)
            System.out.println(no);
    }
}
