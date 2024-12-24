package ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public Integer ordenar(List<Integer> lista) {
        List<String> listaOrdenada = (List)lista.stream().map((item) -> String.valueOf(item)).collect(Collectors.toList());
        listaOrdenada.sort((a, b) -> (b + a).compareTo(a + b));
        String valorAltoStr = "";

        for(String item : listaOrdenada) {
            valorAltoStr = valorAltoStr + item;
        }

        Integer valorAltoInt = Integer.valueOf(valorAltoStr);
        return valorAltoInt;
    }
}
