package application.processoseletivo;

import infra.Facade;
import infra.Result;
import domain.processoseletivo.ProcessoSeletivo;
import domain.processoseletivo.ProcessoSeletivoRepository;
import play.Logger;

import javax.persistence.PersistenceException;

// ou ProcessoSeletivoService
public class ProcessoSeletivoFacade extends Facade {

	private ProcessoSeletivoRepository repositorio;

	public ProcessoSeletivoFacade(ProcessoSeletivoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public Result criarNovoProcesso(NovoProcessoSeletivoDTO dto){

		try {
			ProcessoSeletivo processoSeletivo = new ProcessoSeletivo(dto.titulo);
			//processoSeletivo.
			this.repositorio.salvar(processoSeletivo);

			return Result.sucessCreated("Novo processo seletivo criado com sucesso!", processoSeletivo.id());

		} catch (PersistenceException ex) {

			Logger.error("Erro ");

			return transformarPersistenceAdapterEmResultado(ex, "salvar");

		}
	}

	public void alterarProcesso(AlterarProcessoSeletivoDTO dto) {

		//TODO: alterar
	}

	public Result removerProcesso(Integer processoId) {

		try {
			ProcessoSeletivo processoSeletivo = this.repositorio.obterPorId(processoId);

			//Negócio e regras

			this.enviarEmailParaTodasPessoas(processoSeletivo);

			this.repositorio.remover(processoSeletivo);

			return Result.sucessUpdated("Processo seletivo removido com sucesso!", processoId);

		} catch (Exception e){
			return Result.initWithError(Result.codes.EINTERNAL, "Erro ao enviar email!");
		}
	}

	private void enviarEmailParaTodasPessoas(ProcessoSeletivo processoSeletivo) throws Exception {
		//TODO: impelementar
	}

}
