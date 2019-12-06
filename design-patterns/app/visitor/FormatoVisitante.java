package visitor;

public interface FormatoVisitante {
    void visitarTitulo(String t);
    void visitarSubtitulo(String t);
    void visitarParagrafo(String p);
    void visitarTabela();
    void visitarTabelaCabecalho(String... ct);
    void visitarTabelaLinha(Object... o);
    void visitarTabelaFim();
    void visitarImagem(String path);
    Object getResultado();
}
