package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio_1 {
    public Integer ordenar (List<Integer> lista){

        List<String> listaOrdenada= lista.stream().map(item ->{
            return String.valueOf(item);
        }).collect(Collectors.toList());

        listaOrdenada.sort((a,b)->(b+a).compareTo(a+b));

        String valorAltoStr = "";

        for(String item:listaOrdenada){
            valorAltoStr += item;

        }
        Integer valorAltoInt= Integer.valueOf(valorAltoStr);

        return valorAltoInt;
    }
}
