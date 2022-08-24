package negocios;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GerenciadoraClientesTest{

    protected List<Cliente> clientesDoBanco;

    protected GerenciadoraClientes gerClientes;

    protected List<ContaCorrente> contasBanco;

    protected GerenciadoraContas gerContas;
    String nomeCLiente01 = "Lucas";
    String emailCliente01 = "lucas@gmail.com";
    String nomeCLiente02 = "Joseph";
    String emailCliente02 = "joester@gmail.com";

    @Test
    public void cadastrarIdExistente(){
        /* ---- Cenario ----*/
        clientesDoBanco = new ArrayList<>();

        Cliente cliente01 = new Cliente(1,nomeCLiente01,20,emailCliente01,1,true);
        Cliente cliente02 = new Cliente(1,nomeCLiente02,21,emailCliente02,1,true);

        /* ---- Execucao ---*/
        clientesDoBanco.add(cliente01);

        /* ---- Verificacao ----*/
        try {
            clientesDoBanco.add(cliente02);
            Assert.assertTrue("ID repetido",false);

        }catch (Exception e){
            Assert.assertTrue("Insercao Invalida",true);
        }
        gerClientes.limpa();
    }

    @Test
    public void cadastrarClienteMenorDeIdade(){
        try {
            Cliente cliente = new Cliente(1,nomeCLiente01,17,emailCliente01,1,true);
            Assert.assertTrue("Usuario abaixo dos 18 cadastrado",false);
        }catch (Exception e){
            Assert.assertTrue("Usuario abaixo dos 18 nao cadstrado",true);
        }
    }
    @Test
    public void cadastrarClienteAcimaDaIdade(){
        try {
            Cliente cliente = new Cliente(1,nomeCLiente01,66,emailCliente01,1,true);
            Assert.assertTrue("Usuario acima dos 65 cadstrado",false);
        }catch (Exception e){
            Assert.assertTrue("Usuario acima dos 65 nao cadstrado",true);
        }
    }
    @Test
    public void cadastrarClienteExtremoSuperior(){
        try {
            Cliente cliente = new Cliente(1,nomeCLiente01,65,emailCliente01,1,true);
            Assert.assertEquals("Usuario cadastrado",nomeCLiente01,cliente.getNome());
        }catch (Exception e){
            Assert.assertTrue("Usuario nao cadstrado",false);
        }
    }
    @Test
    public void cadastrarClienteExtremoInferior(){
        try {
            Cliente cliente = new Cliente(1,nomeCLiente01,18,emailCliente01,1,true);
            Assert.assertEquals("Usuario cadastrado",nomeCLiente01,cliente.getNome());
        }catch (Exception e){
            Assert.assertTrue("Usuario nao cadstrado",false);
        }
    }

}
