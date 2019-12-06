package visitor;

import java.util.List;

public class ComprasCliente implements Relatorio {
    private Cliente cliente;
    private List<Item> itens;

    @Override
    public Object gerarRelatorio(FormatoVisitante fv) {
        fv.visitarTitulo("Compras de " + cliente.nome());
        fv.visitarParagrafo("CPF" + cliente.cpf());
        fv.visitarParagrafo("Cliente deste " + cliente.dataHora());

        fv.visitarTabela();
        fv.visitarTabelaCabecalho("Produto", "Data", "Valor");
        for(Item item: itens)
            fv.visitarTabelaLinha(item.produto(), item.dataCompra(), item.valor());
        fv.visitarTabelaFim();
        return fv.getResultado();
    }
}
