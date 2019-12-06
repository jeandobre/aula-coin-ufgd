package entities;

import double_dispatch.CarrinhoCompras;

public abstract class Produto {
	private int id;

	public abstract void adicionarPropriedades(CarrinhoCompras c);
}
