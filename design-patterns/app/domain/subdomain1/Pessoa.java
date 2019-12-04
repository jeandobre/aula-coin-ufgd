package domain.subdomain1;

import java.time.LocalDate;

final class Pessoa {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String cargo;

    public Pessoa() {
    }

    public Pessoa chamadaDe(String nome){
        this.nome = nome;
        return this;
    }

    public Pessoa nascidaEm(LocalDate data){
        this.dataNascimento = data;
        return this;
    }

    public Pessoa comCargo(String cargo){
        this.cargo = cargo;
        return this;
    }
}
