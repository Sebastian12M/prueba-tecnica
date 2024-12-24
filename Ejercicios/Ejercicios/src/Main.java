import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList();
        numeros.add(40);
        numeros.add(2);
        numeros.add(1);
        numeros.add(1);
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Integer resultado = ejercicio1.ordenar(numeros);
        System.out.println("El número más grande es: " + resultado);


        Ejercicio2 ejercicio2 = new Ejercicio2();
        ejercicio2.verificarLetra("CAMARA");    }
}