package application.processoseletivo;

import application.Facade;
import application.Result;
import domain.processoseletivo.ProcessoSeletivo;
import domain.processoseletivo.ProcessoSeletivoRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.rmi.UnexpectedException;

// ou ProcessoSeletivoService
public class ProcessoSeletivoFacade extends Facade {

	private ProcessoSeletivoRepository repositorio;

	public ProcessoSeletivoFacade(ProcessoSeletivoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public Result criarNovoProcesso(NovoProcessoSeletivoDTO dto){

		try {
			ProcessoSeletivo processoSeletivo = new ProcessoSeletivo(dto.titulo);

			this.repositorio.salvar(processoSeletivo);

			return Result.sucessCreated("Novo processo seletivo criado com sucesso!", processoSeletivo.id());

		} catch (PersistenceException ex) {

			return transformarPersistenceAdapterEmResultado(ex, "salvar");

		}
	}

	public void alterarProcesso(AlterarProcessoSeletivoDTO dto) {

		//TODO: alterar
	}

	public void removerProcesso(Integer processoId) {
		ProcessoSeletivo processoSeletivo = this.repositorio.obterPorId(processoId);

		//Negócio e regras

		this.enviarEmailParaTodasPessoas(processoSeletivo);

		this.repositorio.remover(processoSeletivo);
	}

	private void enviarEmailParaTodasPessoas(ProcessoSeletivo processoSeletivo) {
		//TODO: impelementar
	}


}
