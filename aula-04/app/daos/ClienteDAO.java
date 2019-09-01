package daos;

import models.Cliente;
import play.data.validation.Validation;

import java.util.List;

public class ClienteDAO implements DAO<Cliente, Integer> {

    @Override
    public void salvar(Cliente model) {
        model.save();
    }

    @Override
    public void remover(Integer id) {
        Cliente cliente = buscarPorId(id);
        if(cliente != null)
            cliente.delete();

    }

    @Override
    public void alterar(Cliente model) {
        Cliente cliente = model.merge();
        cliente.save();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return Cliente.findById(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return Cliente.findAll();
    }
}
