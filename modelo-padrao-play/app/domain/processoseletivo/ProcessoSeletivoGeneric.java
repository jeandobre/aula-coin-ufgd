package domain.processoseletivo;

import infra.GenericDao;

import java.util.List;

public class ProcessoSeletivoGeneric implements GenericDao<ProcessoSeletivo, Integer> {

	@Override
	public ProcessoSeletivo buscarPorId(Integer id) {
		return null;
	}

	@Override
	public List<ProcessoSeletivo> listarTodos() {
		return null;
	}

	@Override
	public void salvar(ProcessoSeletivo entidade) {

	}


}
