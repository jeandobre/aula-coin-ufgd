package domain.processoseletivo;

import domain.Entity;
import domain.processoseletivo.pessoa.Pessoa;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessoSeletivo extends Entity {

	private Integer id;
	private String titulo;
	private List<Pessoa> pessoas;

	public ProcessoSeletivo(String titulo) {
		this.titulo = titulo;

		//TODO event source
	}

	public Integer id() {
		return this.id;
	}

	public String titulo() {
		return this.titulo;
	}

	public Set<Pessoa> pessoas() {
		//Cópia defensiva
		return Collections.unmodifiableSet(this.pessoas.stream().collect(Collectors.toSet()));
	}

	private void setId(Integer id) {
		this.id = id;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private void setPessoa(Pessoa pessoa) {
		//TODO verificar se a pessoa já está cadastrada nesse processo
		this.pessoas.add(pessoa);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProcessoSeletivo that = (ProcessoSeletivo) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(titulo, that.titulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo);
	}

	@Override
	public String toString() {
		return "ProcessoSeletivo [" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				']';
	}
}
