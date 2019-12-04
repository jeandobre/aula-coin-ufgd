package proxy;

public interface DAO {
    Identificavel recuperar(int id);
    void excluir(int id);
    void salvar(Identificavel obj);
}
