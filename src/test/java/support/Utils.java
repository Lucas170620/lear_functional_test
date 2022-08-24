package support;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String getRandomName(){
        ThreadLocalRandom gerador = ThreadLocalRandom.current();

        int tamanhoNome = gerador.nextInt(3, 10);
        int tamanhoSobrenome = gerador.nextInt(3, 10);

        char primeiraLetraNome = (char) gerador.nextInt(65, 90);
        char primeiraLetraSobreNome = (char) gerador.nextInt(65, 90);

        StringBuilder nome = new StringBuilder().append(primeiraLetraNome);
        StringBuilder sobreNome = new StringBuilder().append(primeiraLetraNome);


        for (int i = 1; i < tamanhoNome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            nome.append(letra);
        }

        for (int i = 1; i < tamanhoSobrenome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            sobreNome.append(letra);
        }

        return nome+" "+sobreNome;
    }
    public static Integer getRandomAge(){
        ThreadLocalRandom gerador = ThreadLocalRandom.current();

        return gerador.nextInt(19,64 );
    }
    public static Double getRandomDouble(){
        ThreadLocalRandom gerador = ThreadLocalRandom.current();
        return gerador.nextDouble(1.0,1000.0);
    }
}

