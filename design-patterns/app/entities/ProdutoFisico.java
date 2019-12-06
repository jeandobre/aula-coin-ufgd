package entities;

import double_dispatch.CarrinhoCompras;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {

	private BigDecimal preco;
	private int volume;
	private int peso;

	@Override
	public void adicionarPropriedades(CarrinhoCompras c) {
		c.adicionarPropriedade("PRECO", preco);
		c.adicionarPropriedade("VOLUME", volume);
		c.adicionarPropriedade("PESO", peso);
	}

}
