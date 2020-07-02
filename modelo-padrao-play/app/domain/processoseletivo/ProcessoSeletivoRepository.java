package domain.processoseletivo;

import java.util.Collection;

public interface ProcessoSeletivoRepository {

	public Collection<ProcessoSeletivo> listarTodosProcessos();

	public Collection<ProcessoSeletivo> listarApenasProcessosAbertos();

	public ProcessoSeletivo obterPorId(Integer id);

	public void remover(ProcessoSeletivo processoSeletivo);

	public void removerPorId(Integer id);

	public void salvar(ProcessoSeletivo processoSeletivo);
}
