package negocios;

import negocios.cenarios.addMilContas;
import org.junit.Assert;
import org.junit.Test;

public class GerenciadoraContasPerformTest extends addMilContas {

    @Test
    public void performanceClient(){
        /* Execucao do Teste */
        while(!contasBanco.isEmpty()){
            contasBanco.remove(0);
        }

        /* verificacao */
        Assert.assertTrue("Lista Vazia",contasBanco.isEmpty());
    }
}
