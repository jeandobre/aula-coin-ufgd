package application;

public class Result {

	private int status;
	private String message;
	private Integer entityId;

	public static Result initWithError(int status, String msg){
		Result result = new Result(status);
		result.setMessage(msg);

		return result;
	}

	private static Result initWithId(int status, String msg, Integer id){
		Result result = new Result(status);
		result.setMessage(msg);
		result.setEntityId(id);

		return result;
	}

	public static Result sucessCreated(String msg, Integer newId){
		return initWithId(201, msg, newId);
	}

	public static Result sucessUpdated(String msg, Integer oldId){
		return initWithId(200, msg, oldId);
	}

	private Result(int status) {
		this.status = status;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	private void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
}
