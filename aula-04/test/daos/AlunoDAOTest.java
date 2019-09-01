package daos;

import models.Aluno;

import java.util.List;

public class AlunoDAOTest extends GenericDAO<Aluno, Integer> {

    private List<Aluno> alunos;

    @Override
    void novo(Aluno modelo) {
        //TODO
    }

    @Override
    void alterar(Aluno modelo) {
        //TODO
    }

    @Override
    void remover(Integer id) {
        //TODO
    }

    @Override
    Aluno buscarPorId(Integer id) {
        return alunos.stream().filter( a -> a.id == id)
                .findFirst().get();
    }
}
