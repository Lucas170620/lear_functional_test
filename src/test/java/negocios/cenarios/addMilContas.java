package negocios.cenarios;

import negocios.ContaCorrente;
import negocios.GerenciadoraContas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.Utils;

import java.util.ArrayList;
import java.util.List;

public class addMilContas {

    /* ========== Montagem do cenário ========== */
    protected List<ContaCorrente> contasBanco;

    protected GerenciadoraContas gerContas;

    // criando um mil de contas e inserindo as contas criadas na lista de contas do banco
    @Before
    public void setUp(){
        contasBanco = new ArrayList<ContaCorrente>();
        ContaCorrente contaCorrente;
        for(int i = 1 ; i <1001;i++){
            Double saldo = Utils.getRandomDouble();
            contaCorrente = new ContaCorrente(i,saldo,true);
            contasBanco.add(contaCorrente);
        }


        gerContas = new GerenciadoraContas(contasBanco);
    }
}
