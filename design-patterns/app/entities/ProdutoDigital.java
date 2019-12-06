package entities;

import double_dispatch.CarrinhoCompras;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {

	private BigDecimal preco;
	private int tamanho;

	@Override
	public void adicionarPropriedades(CarrinhoCompras c) {
		c.adicionarPropriedade("PRECO", preco);
		c.adicionarPropriedade("DOWNLOAD", tamanho);
	}

}
