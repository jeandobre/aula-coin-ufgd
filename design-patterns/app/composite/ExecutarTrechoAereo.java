package composite;

public class ExecutarTrechoAereo {

    public static void main(String[] args){
        TrechoSimples ts1 = new TrechoSimples("São Paulo", "Brasilia", 500);
        TrechoSimples ts2 = new TrechoSimples("Brasilia", "Recife", 300);
        TrechoSimples ts3 = new TrechoSimples("Recife", "Natal", 350);

        TrechoComposto tc1 = new TrechoComposto(ts2, ts3, 30);
        TrechoComposto tc2 = new TrechoComposto(ts1, tc1, 50);
    }
}
