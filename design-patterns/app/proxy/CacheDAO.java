package proxy;

import java.util.HashMap;
import java.util.Map;

public class CacheDAO implements DAO {
    private DAO dao;
    private Map<Integer, Identificavel> cache;

    public CacheDAO(DAO dao) {
        this.dao = dao;
        this.cache = new HashMap<>();
    }

    @Override
    public Identificavel recuperar(int id) {
        if(cache.containsKey(id))
            return cache.get(id);
        Identificavel obj = dao.recuperar(id);
        cache.put(id, obj);
        return obj;
    }

    @Override
    public void excluir(int id) {
        dao.excluir(id);
        cache.remove(id);
    }

    @Override
    public void salvar(Identificavel obj) {
        dao.salvar(obj);
        cache.put(obj.id(), obj);
    }
}
