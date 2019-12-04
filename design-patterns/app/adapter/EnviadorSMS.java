package adapter;

public interface EnviadorSMS {
    void enviarSMS(String destino, String origem, String[] msgs)
        throws SMSException;

}
