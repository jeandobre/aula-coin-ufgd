package domain.processoseletivo;

import domain.processoseletivo.pessoa.Pessoa;
import play.data.validation.Required;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "processos_seletivos", schema = "public")
public class ProcessoSeletivo extends infra.Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Required
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
		if (!super.equals(o)) return false;
		ProcessoSeletivo that = (ProcessoSeletivo) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id);
	}

	@Override
	public String toString() {
		return "ProcessoSeletivo [" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				']';
	}
}
