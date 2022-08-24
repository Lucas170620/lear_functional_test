package negocios;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GerenciadoraContasTest {

    protected List<Cliente> clientesDoBanco;

    protected GerenciadoraClientes gerClientes;

    protected List<ContaCorrente> contasBanco;

    protected GerenciadoraContas gerContas;

    public void cadastrarIdExistente(){
        /* ---- Cenario ----*/
        contasBanco = new ArrayList<>();

        ContaCorrente contaCorrente01 = new ContaCorrente(1,0,true);
        ContaCorrente contaCorrente02 = new ContaCorrente(1,0,true);
        /* ---- Execucao ---*/
        contasBanco.add(contaCorrente01);

        /* ---- Verificacao ----*/
        try {
            contasBanco.add(contaCorrente02);
            Assert.assertTrue("ID repetido",false);

        }catch (Exception e){
            Assert.assertTrue("Insercao Invalida",true);
        }
    }
    @Test
    public void transferirSaldoInsuficente(){
        /* ---- Cenario ----*/
        contasBanco = new ArrayList<>();

        ContaCorrente contaCorrente01 = new ContaCorrente(1,100,true);
        ContaCorrente contaCorrente02 = new ContaCorrente(2,0,true);

        contasBanco.add(contaCorrente01);
        contasBanco.add(contaCorrente02);

        gerContas = new GerenciadoraContas(contasBanco);

        /* ----Execucao---*/

        Boolean transferir = gerContas.transfereValor(1,200.0,2);

        /* ---- verificacao ----*/
        Assert.assertFalse("Saldo Insuficiente",transferir);
        Assert.assertEquals("Saldo A mantido",100,gerContas.pesquisaConta(1).getSaldo(),0);
        Assert.assertEquals("Saldo B mantido",0,gerContas.pesquisaConta(2).getSaldo(),0);

    }
    @Test
    public void transferirSaldoSuficente(){
        /* ---- Cenario ----*/
        contasBanco = new ArrayList<>();

        ContaCorrente contaCorrente01 = new ContaCorrente(1,100,true);
        ContaCorrente contaCorrente02 = new ContaCorrente(2,0,true);

        contasBanco.add(contaCorrente01);
        contasBanco.add(contaCorrente02);

        gerContas = new GerenciadoraContas(contasBanco);

        /* ----Execucao---*/

        Boolean transferir = gerContas.transfereValor(1,100.0,2);

        /* ---- verificacao ----*/
        Assert.assertTrue("Saldo Suficiente",transferir);
        Assert.assertEquals("Saldo A alterado",0,gerContas.pesquisaConta(1).getSaldo(),0);
        Assert.assertEquals("Saldo B alterado",100,gerContas.pesquisaConta(2).getSaldo(),0);

    }
    @Test
    public void transferirContaInativa(){
        /* ---- Cenario ----*/
        contasBanco = new ArrayList<>();

        ContaCorrente contaCorrente01 = new ContaCorrente(1,100,false);
        ContaCorrente contaCorrente02 = new ContaCorrente(2,0,true);

        contasBanco.add(contaCorrente01);
        contasBanco.add(contaCorrente02);

        gerContas = new GerenciadoraContas(contasBanco);

        /* ----Execucao---*/

        Boolean transferir = gerContas.transfereValor(1,100.0,2);

        /* ---- verificacao ----*/
        Assert.assertFalse("Conta Inativa Transferiu",transferir);
        Assert.assertEquals("Saldo A mantido",100.0,gerContas.pesquisaConta(1).getSaldo(),0);
        Assert.assertEquals("Saldo B mantido",0,gerContas.pesquisaConta(2).getSaldo(),0);

    }
}
