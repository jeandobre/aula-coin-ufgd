package command;

import entities.Produto;
import entities.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarrinhoCompras {
	private Map<String, ComandoCarrinho> comandos;
	private List<Produto> produtos;
	private Usuario usuario;

	public Object executaComando(String nomeComando) throws ComandoNaoEncontradoException{
		ComandoCarrinho c = comandos.get(nomeComando);
		if(c == null) throw new ComandoNaoEncontradoException();

		if(c instanceof CienteDosProdutos){
			((CienteDosProdutos) c).setProdutos(produtos);
		}

		if(c instanceof CienteDoUsuario){
			((CienteDoUsuario) c).setUsuario(usuario);
		}
		return c.executar();
	}

	public Set<String> comandosDisponiveis() {
		return comandos.keySet();
	}
}
