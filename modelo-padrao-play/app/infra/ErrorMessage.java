package infra;

public class ErrorMessage {

	String status;
	String campo;
	String mensagem;

	public ErrorMessage(String status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}

	public ErrorMessage(String status, String mensagem, String campo) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.campo = campo;
	}

}
