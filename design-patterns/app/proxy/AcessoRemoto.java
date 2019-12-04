package proxy;

import java.io.IOException;

public interface AcessoRemoto {
    byte[] buscarArquivo(String url) throws IOException;
}
