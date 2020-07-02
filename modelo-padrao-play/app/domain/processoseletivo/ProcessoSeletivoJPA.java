package domain.processoseletivo;

import play.db.jpa.JPA;

import java.util.Collection;

public class ProcessoSeletivoJPA implements ProcessoSeletivoRepository {

	@Override
	public Collection<ProcessoSeletivo> listarTodosProcessos() {
		return JPA.em().createNativeQuery("SELECT * FROM ProcessoSeletivo ")
				.getResultList();
	}

	@Override
	public Collection<ProcessoSeletivo> listarApenasProcessosAbertos() {
		return JPA.em().createNativeQuery("SELECT * FROM ProcessoSeletivo " +
				"WHERE ativo = TRUE")
				.getResultList();
	}

	@Override
	public ProcessoSeletivo obterPorId(Integer id) {

		return ProcessoSeletivo.findById(id);
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
