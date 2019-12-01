package chain_of_responsability;

public abstract class RecuperadorArquivo {
    private RecuperadorArquivo proximo;

    public RecuperadorArquivo(RecuperadorArquivo proximo) {
        this.proximo = proximo;
    }

    public Arquivo recuperar(String nome){
        Arquivo a = recuperarArquivo(nome);
        if(a == null || !a.isValido())
            return chamarProximo(nome);

        return a;
    }

    protected Arquivo chamarProximo(String nome){
        if(proximo == null) throw new RuntimeException("Não foi possível recuperar o arquivo");

        return proximo.recuperar(nome);
    }

    protected abstract Arquivo recuperarArquivo(String nome);
}
