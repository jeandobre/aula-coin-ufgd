package handler;

import daos.FuncionarioDAO;
import daos.FuncionarioDAOTest;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

public class FuncionarioLoadTest extends UnitTest {


    @Before
    public void setUp() {
        Fixtures.deleteDatabase();
        Fixtures.loadModels("data-funcionarios.yml");
    }


    @Test
    public void testarDadosDeFuncionariosCarregadoPorArquivoYaml(){

        FuncionarioDAO dao = new FuncionarioDAO();
        assertEquals(3, dao.listarTodos().size());

    }


}
