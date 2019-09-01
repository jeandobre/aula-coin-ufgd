package daos;

import javax.validation.constraints.NotNull;

public abstract class GenericDAO<E, I> {

    abstract void novo(E modelo);

    abstract void alterar(E modelo);

    abstract void remover(I id);

    abstract E buscarPorId(I id);

    public final String gerarRGA(String ano, @NotNull I id){

        String rga = ano + "." + id.toString();
        return rga;
    }



}
