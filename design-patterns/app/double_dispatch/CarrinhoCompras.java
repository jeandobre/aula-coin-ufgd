package double_dispatch;

import entities.Produto;

import java.util.List;

public class CarrinhoCompras {

	private List<Produto> produtos;

	public void adicionarProduto(Produto produto){
		produtos.add(produto);
		produto.adicionarPropriedades(this);
	}

	public void adicionarPropriedade(String key, Object value){

	}
}
