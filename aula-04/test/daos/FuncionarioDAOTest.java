package daos;

import models.Funcionario;
import play.test.Fixtures;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOTest extends FuncionarioDAO {

    private List<Funcionario> funcionarios;

    public FuncionarioDAOTest() {
        funcionarios = new ArrayList<>();

        /*Funcionario funcionario1 = new Funcionario();
        funcionario1.id = new Long(1);
        funcionario1.nome = "Jean Alexandre";
        funcionario1.siape = "1547845";*/

        Fixtures.loadModels("data-funcionarios.yml");
    }

    @Override
    public void salvar(Funcionario model) {
        funcionarios.add(model);
    }

    @Override
    public void remover(Long id) {
        //
    }

    @Override
    public void alterar(Funcionario model) {
        //
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return funcionarios.stream().filter(f -> f.id == id)
                .findFirst().get();
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarios;
    }
}
