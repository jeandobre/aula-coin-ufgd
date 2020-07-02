package application;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

public class Facade {

	//hookMétodo

	protected final Result transformarPersistenceAdapterEmResultado(PersistenceException ex, String acao) {

		String title = "Erro ao " + acao;
		String mensagem = ex.getLocalizedMessage();
		if (ex.getCause() instanceof ConstraintViolationException) {

			ConstraintViolationException cEx = ((ConstraintViolationException) ex.getCause());
			mensagem = transformarMensagemErroVindoBancoDadosPostgreSQL(cEx.getCause().getMessage());

			//code = cEx.getSQLState();
			if (cEx.getCause().getMessage().contains("chave estrangeira")
					|| cEx.getCause().getMessage().contains("foreign key"))
				title += "[chave relacionada]";
			else if (cEx.getCause().getMessage().contains("unique constraint"))
				title += "[chave única duplicada]";

			//status = ENOTFOUND;
		}

		return Result.initWithError(Result.codes.ENOTFOUND, mensagem);
	}

	public static String transformarMensagemErroVindoBancoDadosPostgreSQL(String mensagem){
		String msgRetorno = "";
		if(mensagem.contains("valor nulo na coluna") || mensagem.contains("null value in column")){
			msgRetorno = "O campo " + mensagem.split("\"")[1] + " é obrigatório!";
		} else if(mensagem.contains("ainda é referenciada")){
			msgRetorno = "É necessário remover todas relações (" + mensagem.split("\"")[5] + ") antes de remover este recurso!";
		} else if(mensagem.contains("unique constraint")){
			msgRetorno = "Regra do banco " + mensagem.split("\"")[1] + " foi violada com valores duplicados!";
		} else if(mensagem.contains("foreign key")){
			msgRetorno = "Chave " + mensagem.split("=\\(")[1].split("\\)")[0] + " não encontrada na tabela " + mensagem.split("\"")[5];
		}

		return msgRetorno;
	}
}
