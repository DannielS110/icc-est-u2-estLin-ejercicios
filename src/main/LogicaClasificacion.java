package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String cadenaString) {
        Stack<Character> pila = new Stack<>();
        for (char c: cadenaString.toCharArray()) {
            pila.push(c);
        }
       StringBuilder resultado = new StringBuilder();
        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }
        return resultado.toString(); 
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados. 
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        for(char c: expresion.toCharArray()){
           if(c== '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if(c == ')' || c == '}' || c == ']') {
                if(pila.isEmpty()) return false;
                char ultimo = pila.pop();
                if((c == ')' && ultimo != '(') ||
                   (c == '}' && ultimo != '{') ||
                   (c == ']' && ultimo != '[')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();  
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
    Stack<Integer> pilaAuxiliar = new Stack<>();
    while (!pila.isEmpty()) {
        int temp = pila.pop();
        while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() > temp) {
            pila.push(pilaAuxiliar.pop());
        }
        pilaAuxiliar.push(temp);
    }
    return new ArrayList<>(pilaAuxiliar); // Devuelve la pila ordenada como lista
}


    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
    LinkedList<Integer> pares = new LinkedList<>();
    LinkedList<Integer> impares = new LinkedList<>();
    for (Integer numero : original) {
        if (numero % 2 == 0) {
            pares.add(numero);
        } else {
            impares.add(numero);
        }
    }
    pares.addAll(impares); 
    return pares; 
}
}

