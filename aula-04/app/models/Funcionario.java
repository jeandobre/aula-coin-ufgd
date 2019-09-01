package models;

import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios", schema = "public")
public class Funcionario  extends GenericModel {

    @Id
    public Long id;

    public String siape;

    public String nome;
}
