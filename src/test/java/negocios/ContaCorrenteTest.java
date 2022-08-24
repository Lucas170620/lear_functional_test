package negocios;

import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {

    @Test
    public void cadastrarContaNegativa(){
        try {
            ContaCorrente contaCorrente = new ContaCorrente(1,-1.0,true);
            Assert.assertTrue("Saldo Negativo e conta cadastrada",false);
        }
        catch (Exception e){
            Assert.assertTrue("Saldo negativo e conta nao cadastrada",true);
        }
    }
    @Test
    public void cadastrarContaPositiva(){
        try {
            ContaCorrente contaCorrente = new ContaCorrente(1,0,true);
            Assert.assertEquals(0.0,contaCorrente.getSaldo(),0);
        }
        catch (Exception e){
            Assert.assertTrue("Conta não iniciada",true);
        }
    }
}
