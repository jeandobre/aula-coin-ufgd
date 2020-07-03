package domain.processoseletivo.pessoa;

import infra.Entity;

import java.util.Objects;

public class Pessoa extends Entity {

	private Integer id;

	private String nome;

	private CPF cpf;

	private Endereco endereco;

	public Pessoa(String nome, CPF cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(id, pessoa.id) &&
				Objects.equals(nome, pessoa.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public String toString() {
		return "Pessoa [" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cpf=" + cpf +
				", endereco=" + endereco +
				']';
	}
}
