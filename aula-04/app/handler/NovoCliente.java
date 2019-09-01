package handler;

import daos.DAO;
import models.CPF;
import models.Cliente;
import play.data.validation.Validation;

public class NovoCliente {
    private DAO dao;

    public NovoCliente(DAO dao) {
        this.dao = dao;
    }

    public void criarNovoCliente(String nome, String cpf, String celular) throws Exception{

        if(nome == null || nome.equals(""))
            throw new Exception("Erro de validação de nome");


        Cliente cliente = Cliente.novoCliente(nome, cpf, celular);

        Validation.clear();
        cliente.validar();
        if(Validation.hasErrors()){
           throw new Exception("Erro de validação de cpf");
        }

        dao.salvar(cliente);

    }

}
