package handler;

import daos.AlunoDAO;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

public class NovoAlunoTest extends UnitTest {

    private AlunoDAO dao;
    private NovoAluno novoAluno;

    @Before
    public void inicializar(){
        dao = new AlunoDAO();
        novoAluno = new NovoAluno(dao);
    }

    @Test
    public void deveGerarRGACorretamente(){
        String ano = "2019";
        Integer id = 1545;

        String rgaCorreto = "2019.1545";
        String rgaGerado = novoAluno.gerarRGA(ano, id);

        assertEquals(rgaCorreto, rgaGerado);

    }


}
