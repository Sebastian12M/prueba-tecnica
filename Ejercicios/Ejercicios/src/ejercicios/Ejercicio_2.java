package ejercicios;

public class Ejercicio_2 {

    public void verificarLetra(String texto){

        String textoArray[]= texto.split("");

        for (int i = 0 ; i<textoArray.length;i++){
            if(textoArray[i].equalsIgnoreCase("a")){
                System.out.println("La letra 'a' se encuentra en la posición "+(i+1));
            }
        }
    }

}
