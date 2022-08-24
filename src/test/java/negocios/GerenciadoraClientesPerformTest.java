package negocios;

import negocios.cenarios.addMilClientes;
import org.junit.Assert;
import org.junit.Test;

public class GerenciadoraClientesPerformTest extends addMilClientes {
    @Test
    public void performanceClient(){
        /* Execucao do Teste */
        while(!clientesDoBanco.isEmpty()){
            clientesDoBanco.remove(0);
        }

        /* verificacao */
        Assert.assertTrue("Lista Vazia",clientesDoBanco.isEmpty());
    }
}
