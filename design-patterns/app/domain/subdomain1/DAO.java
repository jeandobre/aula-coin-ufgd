package domain.subdomain1;

class DAO {
    private Pessoa entidade;

    public Pessoa buscarEntidadePorNome(String nome){
        return new Pessoa()
                .chamadaDe("Joao")
                .comCargo("Gerente");
    }
}
