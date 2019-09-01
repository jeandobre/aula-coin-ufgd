package handler;

import daos.AlunoDAO;

public class NovoAluno {

    private AlunoDAO dao;

    public NovoAluno(AlunoDAO dao) {
        this.dao = dao;
    }

    public String gerarRGA(String ano, Integer id){
        return dao.gerarRGA(ano, id);
    }

}
