package domain.processoseletivo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProcessoSeletivoMockLocal implements ProcessoSeletivoRepository {

	private List<ProcessoSeletivo> lista;

	public ProcessoSeletivoMockLocal() {
		lista = new ArrayList<>();
	}

	@Override
	public Collection<ProcessoSeletivo> listarTodosProcessos() {
		return lista;
	}

	@Override
	public Collection<ProcessoSeletivo> listarApenasProcessosAbertos() {
		return lista;
	}

	@Override
	public ProcessoSeletivo obterPorId(Integer id) {
		return null;
	}

	@Override
	public void remover(ProcessoSeletivo processoSeletivo) {

	}

	@Override
	public void removerPorId(Integer id) {

	}

	@Override
	public void salvar(ProcessoSeletivo processoSeletivo) {

	}
}
