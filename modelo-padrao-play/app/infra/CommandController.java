package infra;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import play.Logger;
import play.data.validation.Error;
import play.data.validation.Validation;
import play.mvc.After;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandController  extends Controller {

	public String cpf = "";
	public Boolean acessoIndividual = Boolean.FALSE;

	@After
	public static void setCORS(){
		//TODO resolver isso aki
		response.removeCookie("PLAY_ERRORS");
		response.removeCookie("PLAY_FLASH");
		response.removeCookie("PLAY_SESSION");
		response.accessControl("http://localhost", "GET", true);
	}

	@Before(priority = 1)
	public void inicializar(){

	}

	@Before(priority = 2)
	public void verificarContentType(){

		Http.Header header = request.headers.get("content-type");
		if(header == null){
			renderJSON(new ErrorMessage("415",
					"Não aceitável","O tipo de conteúdo(content-type) não pode ser nulo ou vazio!"));
		}

		if(header != null && !header.value().equals("application/json") && !request.method.equals("DELETE")){
			renderJSON(new ErrorMessage("415",
					"Não suportado", "Tipo de media não suportado - " + header.value()));
		}
	}

	@Before(priority = 3)
	public void verificarSeRequisicaoVemDoGatewayEObterCPF(){
		Http.Header headerGateway = request.headers.get("x-gateway");
		Boolean acessoGateway = Boolean.FALSE;
		if(headerGateway != null) {
			acessoGateway = Boolean.valueOf(headerGateway.value());
			if(acessoGateway) Logger.info("Acesso vindo do gateway!");
			else Logger.info("Acesso direto!");
		} else Logger.info("Acesso direto!");

		Http.Header headerCPF = request.headers.get("x-usercpf");
		if(headerCPF != null){
			cpf = headerCPF.value();
		}

		Http.Header headerIndividual = request.headers.get("x-user-individual");
		if(headerIndividual != null){
			acessoIndividual = Boolean.valueOf(headerIndividual.value());
		}

	}

	protected abstract Boolean estaNulo(Integer id);

	protected final void validarParametros(Integer id, String type){
		if (id == null) {
			response.status = 400;
			renderJSON(new ErrorMessage("400", "O parâmetro 'id' do " + type + " não pode ser nulo ou vazio."));
		}

		if (id <= 0) {
			response.status = 400;
			renderJSON(new ErrorMessage("400", "O parâmetro 'id' do " + type + " não pode ser menor ou igual a zero."));
		}

		if(estaNulo(id)) renderIdNuloDoTipo(id, type);

	}

	private final void renderIdNuloDoTipo(Integer id, String type){
		response.status = 512;
		renderJSON(new ErrorMessage("512", "O " + type + " com o id " + id + " não foi encontrado!"));

	}

	public static final void validarEApresentarMensagem() {

		if (Validation.hasErrors()) {

			response.status = 512;
			List<ErrorMessage> mensagens = new ArrayList<>();
			for (Error error : validation.errors()) {
				mensagens.add(new ErrorMessage("512", error.message(), error.getKey()));
			}
			renderJSON(mensagens);
		}
	}

	protected final Dto validarJsonEObterDto(JsonObject objetoData, Dto classe){

		if (objetoData.get("data") == null) {
			response.status = 400;
			renderJSON(new ErrorMessage("400","O campo data não pode ser nulo ou vazio!"));
		}

		Dto dto = null;
		try {
			Gson gson = new Gson();

			dto = gson.fromJson(objetoData.get("data"), classe.getClass());
		} catch (Exception e){

			Logger.error("converter data para json: ", objetoData.get("data").toString());
			response.status = 400;
			renderJSON(new ErrorMessage("400", "O JSON do campo data é inválido!"));
		}

		if(dto == null){
			renderJSON(new ErrorMessage("400", "O objeto data não pode ser nulo ou vazio!"));
		}

		return dto;
	}
}
