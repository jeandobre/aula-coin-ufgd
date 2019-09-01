package daos;

import models.Aluno;

public class AlunoDAO extends GenericDAO<Aluno, Integer> {

    @Override
    void novo(Aluno modelo) {
        modelo.save();
    }

    @Override
    void alterar(Aluno modelo) {
        Aluno aluno = modelo.merge();
        aluno.save();
    }

    @Override
    void remover(Integer id) {
        Aluno aluno = buscarPorId(id);
        if(aluno != null) aluno.delete();
    }

    @Override
    Aluno buscarPorId(Integer id) {
        return Aluno.findById(id);
    }
}
