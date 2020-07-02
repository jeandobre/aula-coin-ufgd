package domain.processoseletivo.pessoa;

import domain.ValueObject;

public class Endereco extends ValueObject {

	private String cep;
	private String rua;
	private String numero;
	private String bairro;

	public Endereco(String cep) {
		this.cep = cep;
	}
}

