package facade;

import template_method.GeradorArquivo;
import template_method.GeradorPropriedadesCriptografado;
import template_method.GeradorXMLCompactado;

import java.io.IOException;
import java.util.Map;

public class GeradorArquivoFacade {

    public void gerarXMLCompactado(String nome, Map<String, Object> propriedades)
            throws IOException {
        GeradorArquivo g = new GeradorXMLCompactado();
        g.gerarArquivo(nome, propriedades);
    }

    public void gerarPropriedades(String nome, Map<String, Object> propriedades)
            throws IOException {
        GeradorArquivo g = new GeradorPropriedadesCriptografado(10);
        g.gerarArquivo(nome, propriedades);
    }

    // outros métodos
}
