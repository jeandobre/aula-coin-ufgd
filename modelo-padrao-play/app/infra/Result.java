package infra;

import com.google.gson.JsonObject;

public class Result {

	public static String versao = "1.0";

	private codes status;
	private String message;
	private Integer entityId;

	public enum codes {

		CREATED(201),
		OK(200),
		//validação frontend
		ECONFLICT(409),
		EPERSISTENCE(409),
		ENOTFOUND(400),
		EVALIDATION(405),

		//Erros de regras de negócio

		//Erros ao processar qualquer coisa
		EINTERNAL(500);

		public int codigo;

		codes(int codigo) {
			this.codigo = codigo;
		}
	}

	public static Result initWithError(codes status, String msg){
		Result result = new Result(status);
		result.setMessage(msg);

		return result;
	}

	private static Result initWithId(codes status, String msg, Integer id){
		Result result = new Result(status);
		result.setMessage(msg);
		result.setEntityId(id);

		return result;
	}

	public static Result sucessCreated(String msg, Integer newId){
		return initWithId(codes.CREATED, msg, newId);
	}

	public static Result sucessUpdated(String msg, Integer oldId){
		return initWithId(codes.OK, msg, oldId);
	}

	private Result(codes status) {
		this.status = status;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	private void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public JsonObject toJson(){
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("status", this.status.codigo);

		if(this.status.codigo >= 400){
			jsonObject.addProperty("error", message);
		} else {
			jsonObject.addProperty("ok", message);
		}

		jsonObject.add("jsonapi-ufgd", obterVersaoAsJson());

		return jsonObject;
	}

	public static JsonObject obterVersaoAsJson(){

		JsonObject versaoApi = new JsonObject();
		versaoApi.addProperty("version", versao);

		return versaoApi;
	}
}
