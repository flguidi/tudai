package tp05.e01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Se instancia una pila y se muestra por pantalla
        Pila pila = new Pila();
        System.out.println("Se instancia una pila: " + pila);

        // Se agregan elementos
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");
        pila.push("Elemento 4");
        pila.push("Elemento 5");
        System.out.println("Se agregan elementos: " + pila);

        // Se eliminan elementos
        pila.pop();
        pila.pop();
        System.out.println("Se eliminan elementos: " + pila);

        // Se consulta el último elemento
        System.out.println("Último elemento: " + pila.top());

        // Se consulta el tamaño de la pila
        System.out.println("Tamaño: " + pila.size());

        // Se guarda una copia de la pila y se muestra por pantalla
        ArrayList<Object> copiaPila = pila.copy();
        System.out.println("Copia de pila: " + copiaPila);

        // Se guarda una copia de la pila invertida y se muestra por pantalla
        ArrayList<Object> pilaInvertida = pila.reverse();
        System.out.println("Copia de pila invertida: " + pilaInvertida);
    }
}
