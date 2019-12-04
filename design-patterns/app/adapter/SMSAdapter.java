package adapter;

public class SMSAdapter implements SMSSender {
    private EnviadorSMS env;

    public SMSAdapter(EnviadorSMS env) {
        this.env = env;
    }

    public boolean sendSMS(SMS sms){
        String destino = sms.destino();
        String origem = sms.origem();
        String[] txts = quebrarMsgs(sms.texto());
        try{
            env.enviarSMS(destino, origem, txts);
        } catch (SMSException e){
            return false;
        }
        return true;
    }

    private String[] quebrarMsgs(String text){
        int size = text.length();
        int TAMANHO_MAXIMO = 160;

        int quantidade = (size % TAMANHO_MAXIMO == 0) ? size / TAMANHO_MAXIMO : size / TAMANHO_MAXIMO + 1;
        String[] msgs = new String[quantidade];
        for(int i = 0; i < quantidade; i++){
            int min = i * TAMANHO_MAXIMO;
            int max = (i == quantidade - 1) ? size: (i + 1) * TAMANHO_MAXIMO;
            msgs[i] = text.substring(min, max);
        }
        return msgs;
    }
}
