package controllers;

import infra.Result;
import application.processoseletivo.NovoProcessoSeletivoDTO;
import application.processoseletivo.ProcessoSeletivoFacade;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import domain.processoseletivo.ProcessoSeletivoJPA;
import domain.processoseletivo.ProcessoSeletivoRepository;
import infra.CommandController;
import play.mvc.Before;
import java.io.InputStreamReader;

public class ProcessoSeletivoCommands extends CommandController {

	private static ProcessoSeletivoRepository repositorio;

	@Before
	public static void incializarRepositorio() {
		repositorio = new ProcessoSeletivoJPA();
	}

	public void novo() {

		JsonObject objetoData = new GsonBuilder().create().fromJson(new InputStreamReader(request.body), JsonObject.class);
		NovoProcessoSeletivoDTO dto = (NovoProcessoSeletivoDTO) validarJsonEObterDto(objetoData, new NovoProcessoSeletivoDTO());

		//Inversão de dependência
		ProcessoSeletivoFacade facade = new ProcessoSeletivoFacade(repositorio);
		Result result = facade.criarNovoProcesso(dto);

		renderJSON(result.toJson());
	}

	public static void remover(Integer id) {

		ProcessoSeletivoFacade facade = new ProcessoSeletivoFacade(repositorio);
		Result result = facade.removerProcesso(id);

		renderJSON(result.toJson());
	}

	@Override
	protected Boolean estaNulo(Integer id) {
		return false;
	}
}
