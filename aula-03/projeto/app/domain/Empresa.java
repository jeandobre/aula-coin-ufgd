package domain;

public class Empresa {

    public String cnpj;

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean estaValidoCNPJ(){
        if(cnpj == null || cnpj.length() == 0) return Boolean.FALSE;

        return cnpj.length() == 18;
    }
}
