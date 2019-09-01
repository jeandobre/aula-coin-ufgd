package daos;

import models.Funcionario;

import java.util.List;

public class FuncionarioDAO implements DAO<Funcionario, Long> {

    @Override
    public void salvar(Funcionario model) {
        model.save();
    }

    @Override
    public void remover(Long id) {
        Funcionario funcionario = buscarPorId(id);
        if(funcionario != null)
            funcionario.delete();
    }

    @Override
    public void alterar(Funcionario model) {
        //TODO
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return Funcionario.findById(id);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return Funcionario.findAll();
    }
}
