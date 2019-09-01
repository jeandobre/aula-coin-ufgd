package daos;

import java.util.List;

public interface DAO<E,I> {

    void salvar(E model);

    void remover(I id);

    void alterar(E model);

    E buscarPorId(I id);

    List<E> listarTodos();

}
