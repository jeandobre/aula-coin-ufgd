package models;

import play.db.jpa.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alunos", schema = "public")
public class Aluno extends GenericModel {

    @Id
    public Integer id;

    public String rga;

    public String nome;


}
