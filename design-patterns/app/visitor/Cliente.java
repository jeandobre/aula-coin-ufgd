package visitor;

import java.time.LocalDate;

public class Cliente {

    private String nome;
    private String cpf;
    private LocalDate dataHora;

    public String nome(){
        return "";
    }

    public String cpf() {
        return cpf;
    }

    public LocalDate dataHora() {
        return dataHora;
    }
}
