package handler;

import daos.ClienteDAOTest;
import daos.DAO;
import models.CPF;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

public class NovoClienteTest extends UnitTest {

    NovoCliente novoCliente;
    DAO dao;

    @Before
    public void inicializar(){

        dao = new ClienteDAOTest();
        novoCliente = new NovoCliente(dao);
    }


    @Test
    public void deveSalvarClienteComDadosCorretos() throws Exception{

        int tamanho = dao.listarTodos().size();
        assertEquals(3, tamanho);

        novoCliente.criarNovoCliente("Morango", "885.585.858-85", "67-45854-5565");

        int novoTamanho = dao.listarTodos().size();
        assertEquals(4, novoTamanho);

    }

    @Test
    public void naoDeveSalvarClienteComCPFVazio(){

        try {
            novoCliente.criarNovoCliente("Morango", "", "67-45854-5565");
            fail("Deveria ocorrer erro de validação de CPF");
        } catch (Exception e){
            assertEquals("Erro de validação de cpf", e.getMessage());
        }

    }

    @Test
    public void naoDeveSalvarClienteSemNome(){
        try {
            novoCliente.criarNovoCliente("", "458.458.254-54", "67-45854-5565");
            fail("Deveria ocorrer erro de validação de nome");
        } catch (Exception e){
            assertEquals("Erro de validação de nome", e.getMessage());
        }

    }


}
