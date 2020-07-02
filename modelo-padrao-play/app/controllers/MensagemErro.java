package controllers;

public class MensagemErro {

	String status;
	String campo;
	String mensagem;

	public MensagemErro(String status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}

	public MensagemErro(String status, String mensagem, String campo) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.campo = campo;
	}

}
