package models;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente extends GenericModel {

    @Id
    public Integer id;

    public String nome;

    @Required(message = "Aluno é obrigatório")
    public String cpf;

    public String celular;


    private Cliente() {
    }

    public void validar(){
        Validation.current().valid(this);
    }

    public static Cliente novoCliente(String nome, String cpf, String celular){
        Cliente cliente = new Cliente();
        cliente.nome = nome;
        cliente.cpf = cpf;
        cliente.celular = celular;
        return cliente;
    }
}
