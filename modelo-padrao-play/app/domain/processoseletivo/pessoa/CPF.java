package domain.processoseletivo.pessoa;

public class CPF {

	private String numero;

	public CPF(String numero) {
		this.setNumero(numero);
	}

	public String numero() {
		return numero;
	}

	private void setNumero(String numero) {
		this.numero = numero;
	}
}
