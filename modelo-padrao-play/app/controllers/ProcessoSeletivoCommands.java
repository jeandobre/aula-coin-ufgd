package controllers;

import application.processoseletivo.NovoProcessoSeletivoDTO;
import application.processoseletivo.ProcessoSeletivoFacade;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import domain.processoseletivo.ProcessoSeletivo;
import domain.processoseletivo.ProcessoSeletivoJPA;
import domain.processoseletivo.ProcessoSeletivoRepository;
import play.Logger;
import play.exceptions.UnexpectedException;
import play.mvc.Before;
import play.mvc.Controller;

import javax.persistence.PersistenceException;
import java.io.InputStreamReader;

public class ProcessoSeletivoCommands extends CommandController {

	private static ProcessoSeletivoRepository repositorio;
	private static int EVALIDATION = 412;

	@Before
	public static void incializarRepositorio() {
		repositorio = new ProcessoSeletivoJPA();
	}

	public void novo() {

		try{
			JsonObject objetoData = new GsonBuilder().create().fromJson(new InputStreamReader(request.body), JsonObject.class);
			NovoProcessoSeletivoDTO dto = (NovoProcessoSeletivoDTO) validarJsonEObterDto(objetoData, new NovoProcessoSeletivoDTO());

			//Inversão de dependência
			ProcessoSeletivoFacade facade = new ProcessoSeletivoFacade(repositorio);
			facade.criarNovoProcesso(dto);

		//Erro genérico, de mais alto nível
		//Ideal seria enviar o comando e receber um resultado
		} catch (Exception ex) {
			Logger.error("Erro ao criar novo processo de seleção: " + ex.getMessage());
			response.status = 500;
			renderJSON(new MensagemErro("500", ex.getMessage()));
		}
	}

	public static void remover() {

	}

	@Override
	protected Boolean estaNulo(Integer id) {
		return false;
	}
}
