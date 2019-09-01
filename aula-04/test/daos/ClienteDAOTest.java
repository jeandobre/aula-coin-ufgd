package daos;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOTest implements DAO<Cliente, Integer> {

    private List<Cliente> clientes;

    public ClienteDAOTest() {

        Cliente cliente1 = Cliente.novoCliente("Jean Alexandre Dobre","745.565.565-85", "67-99221-5245");
        cliente1.id = 1;

        Cliente cliente2 = Cliente.novoCliente("José de Alencar da Silva", "154.456.456-85", "41-86956-5854");
        cliente2.id = 2;

        Cliente cliente3 = Cliente.novoCliente("Paulo Antonio", "548.452.669-54", "69-65955-5854");
        cliente3.id = 3;

        clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
    }

    @Override
    public void salvar(Cliente model) {
        clientes.add(model);
    }

    @Override
    public void remover(Integer id) {
        //TODO implementar
    }

    @Override
    public void alterar(Cliente model) {

    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clientes.stream().filter(c -> c.id == id)
                .findFirst().get();
    }

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }
}
