package domain;

import java.util.List;

public interface GenericDao<E, I> {

	public E buscarPorId(I id);

	public List<E> listarTodos();

	public void salvar(E entidade);
}
