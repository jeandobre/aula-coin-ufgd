package command;

public abstract class ComandoCarrinhoChain {
	private ComandoCarrinhoChain proximo;

	public ComandoCarrinhoChain(ComandoCarrinhoChain proximo) {
		this.proximo = proximo;
	}

	public void executar(){
		executarComando();
		if(proximo != null)
			proximo.executar();
	}

	protected abstract void executarComando();
	public abstract Object getResultado();
}
