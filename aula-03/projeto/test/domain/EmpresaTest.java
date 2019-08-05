package domain;

import org.junit.Test;
import play.test.UnitTest;

public class EmpresaTest extends UnitTest {


    @Test
    public void deveValidarCnpjComDadosCertos(){
        //Cenário de teste
        Empresa empresa = new Empresa("14.003.004/0001-25");

        //Execução
        Boolean cnpjEstaValido = empresa.estaValidoCNPJ();

        //Verificação
        assertTrue(cnpjEstaValido);
    }

    @Test
    public void deveAtirarErroAoValidarCnpjComDadosErrados(){
        //vazio
        Empresa empresa = new Empresa("");
        //Execução
        Boolean cnpjEstaValido = empresa.estaValidoCNPJ();
        //Verificação
        assertFalse(cnpjEstaValido);


        //nulo
        empresa = new Empresa(null);
        //Execução
        cnpjEstaValido = empresa.estaValidoCNPJ();
        //Verificação
        assertFalse(cnpjEstaValido);

    }

}
