package domain;

public class Empresa {

    private String cnpj;
    public String nomeFantasia;

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean estaValidoCNPJ(){
        if(cnpj == null || cnpj.length() == 0) return Boolean.FALSE;

        return cnpj.length() == 18;
    }

    public Boolean estaValidoNomeFantasia(){
        if(nomeFantasia.length() > 0) return Boolean.TRUE;

        return Boolean.FALSE;
    }
}
