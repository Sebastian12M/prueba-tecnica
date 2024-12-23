import ejercicios.Ejercicio_1;
import ejercicios.Ejercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(50);
        numeros.add(2);
        numeros.add(1);
        numeros.add(9);

        Ejercicio_1 ejercicio1 = new Ejercicio_1();
        Integer resultado = ejercicio1.ordenar(numeros);

        System.out.println("Resultado Ejercicio 1: " + resultado);


        Ejercicio_2 ejercicio2 = new Ejercicio_2();
        ejercicio2.verificarLetra("CAMARA");

    }



}