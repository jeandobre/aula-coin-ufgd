package command;

import entities.Produto;

import java.util.List;

public class TamanhoParaDownload implements ComandoCarrinho, CienteDosProdutos {

	private List<Produto> produtos;

	@Override
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public Object executar() {
		return null;
	}
}
