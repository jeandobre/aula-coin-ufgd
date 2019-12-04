package dynamic_factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FabricaDinamica {
    private Properties properties;

    public FabricaDinamica criarPorArquivo(String arquivo) throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream(arquivo));
        return this;
    }

    public <E> E criarImplementacao(Class<E> innerface){
        String nomeClasse = properties.getProperty(innerface.getName());
        if(nomeClasse == null){
            throw new IllegalArgumentException("Interface não configurada");
        }
        try{
            Class clazz = Class.forName(nomeClasse);
            if(innerface.isAssignableFrom(clazz)){
                return (E) clazz.newInstance();
            } else {
                throw new IllegalArgumentException("Classe configurada não implementa a interface");
            }
        } catch (ClassNotFoundException e){
            throw new IllegalArgumentException("Classe configurada não existe", e);
        } catch (Exception e){
            throw new IllegalArgumentException("Não foi possível criar a implementação", e);
        }
    }
}

