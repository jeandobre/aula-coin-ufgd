package application.processoseletivo;

import domain.processoseletivo.ProcessoSeletivo;
import domain.processoseletivo.ProcessoSeletivoRepository;

// ou ProcessoSeletivoService
public class ProcessoSeletivoFacade {

	private ProcessoSeletivoRepository repositorio;

	public ProcessoSeletivoFacade(ProcessoSeletivoRepository repositorio) {
		this.repositorio = repositorio;
	}

	public void criarNovoProcesso(NovoProcessoSeletivoDTO dto){

		ProcessoSeletivo processoSeletivo = new ProcessoSeletivo(dto.titulo);

		this.repositorio.salvar(processoSeletivo);
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
