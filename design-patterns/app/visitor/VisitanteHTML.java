package visitor;

public class VisitanteHTML implements FormatoVisitante {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visitarTitulo(String t) {
        sb.append("<h1>")
                .append(t)
                .append("</h1>");
    }

    @Override
    public void visitarSubtitulo(String t) {
        sb.append("<h2>")
                .append(t)
                .append("<h2>");
    }

    @Override
    public void visitarParagrafo(String p) {
        sb.append("<p>")
                .append(p)
                .append("</p>");
    }

    @Override
    public void visitarTabela() {
        sb.append("<table>");
    }

    @Override
    public void visitarTabelaCabecalho(String... ct) {
        sb.append("<tr>");
        for(String s : ct){
            sb.append("<th>")
                    .append(s)
                    .append("</th>");
        }
        sb.append("</tr>");
    }

    @Override
    public void visitarTabelaLinha(Object... obs) {
        sb.append("<tr>");
        for(Object o :obs){
            sb.append("<td>")
                    .append(o)
                    .append("</td>");
        }
        sb.append("</tr>");
    }

    @Override
    public void visitarTabelaFim() {
        sb.append("</table>");
    }

    @Override
    public void visitarImagem(String path) {
        sb.append("<img src='")
                .append(path)
                .append("'>");
    }

    @Override
    public Object getResultado() {
        return sb.toString();
    }
}
