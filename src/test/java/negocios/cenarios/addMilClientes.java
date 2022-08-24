package negocios.cenarios;

import negocios.Cliente;
import negocios.GerenciadoraClientes;
import org.junit.After;
import org.junit.Before;
import support.Utils;

import java.util.ArrayList;
import java.util.List;

public class addMilClientes {

    protected List<Cliente> clientesDoBanco;

    protected GerenciadoraClientes gerClientes;

    @Before
    public void setUp() {

        /* ========== Montagem do cenário ========== */

        // criando um mil clientes e inserindo os clientes criados na lista de clientes do banco
        clientesDoBanco = new ArrayList<Cliente>();
        Cliente cliente;
        for(int i = 1 ; i <1001;i++){
            String name = Utils.getRandomName();
            cliente = new Cliente(i,name, Utils.getRandomAge(), name.replace(" ","_")+"@gmail.com", i, true);
            clientesDoBanco.add(cliente);
        }


        gerClientes = new GerenciadoraClientes(clientesDoBanco);
    }

    @After
    public void tearDown() {
        gerClientes.limpa();
    }
}
