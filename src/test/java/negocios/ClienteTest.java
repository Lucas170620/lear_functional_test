package negocios;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
    Integer idCliente01 = 1 ;
    String nomeCliente01 = new String("Lucas Candido Santos");
    Integer idadeCliente01 = 20 ;
    @Test
    public void cadastrarEmailInvalido(){
        try {
            Cliente cliente = new Cliente(idCliente01,nomeCliente01,idadeCliente01,"Lucas Candido Santos@gmail.com",1,true);
            Assert.assertTrue("E-mail Invalido Aceito",false);
        }
        catch (Exception e){
            Assert.assertTrue("E-mail Invalido nao aceito",true);
        }
    }
}
