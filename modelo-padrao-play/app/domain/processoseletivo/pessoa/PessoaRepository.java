package domain.processoseletivo.pessoa;

import java.util.Collection;

public interface PessoaRepository {

	public Collection<Pessoa> todasPessoasPorProcessoSeletivo(Integer processoSeletivoId);

	public void remove(Pessoa pessoa);

	public void save(Pessoa pessoa);
}
