package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 26 --- */

/* 
Suponer que se tienen dos arreglos A y B de secuencias (de caracteres separados por uno o más espacio) de tamaño
MAX (cada arreglo empieza y termina con uno o más caracteres espacio). A y B están precargados y además se tienen
los siguientes métodos (existen y no se tienen que implementar):
    a. un método que permite obtener el índice inicial de la secuencia que más se repite de un arreglo de secuencias
       de tamaño MAX (que empieza y termina con uno o más caracteres espacios).
    b. un método que retorna el índice inicial de la secuencia que tiene más caracteres repetidos de un arreglo de
       secuencias (de caracteres separados por uno o más caracteres espacio) de tamaño MAX (que empieza y termina
       con espacio).
Se pide realizar un programa completo que (sin utilizar arreglos auxiliares/extras a los mencionados) reemplace en
A la secuencia que más se repite por la secuencia de B con más caracteres repetidos (la separación previa entre las
secuencias de A debe mantenerse). Considerar poner un separador al final del arreglo si se desplaza a derecha para
mantener consistencia en la terminación de la secuencia. En caso de utilizar uno o más de los métodos preexistentes
mencionados en el enunciado definir el o los encabezados de los mismos. No se requiere hacer métodos de carga e
impresión de arreglos.
*/

public class E26 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        char[] a = { ' ', 'a', 'b', 'c', ' ', 'a', 'b', 'c', ' ', 'd', 'e', ' ', 'a', 'b', 'c', ' ', 'd', 'e', ' ', ' ' };
        char[] b = { ' ', ' ', 'f', 'f', 'g', 'f', 'f', 'f', 'g', ' ', 'g', 'g', 'f', 'f', 'g', ' ', 'g', 'f', 'g', ' ' };    

        // El índice de la secuencia más repetida en el arreglo A es 1
        int inicioSecuenciaMasRepetida = 1;

        // El índice de la secuencia con más caracteres repetidos en el arreglo B es 2
        int inicioSecuenciaConMasCaracteresRepetidos = 2;

        imprimirArreglo(a);
        imprimirArreglo(b);

        reemplazarSecuencias(a, b, inicioSecuenciaMasRepetida, inicioSecuenciaConMasCaracteresRepetidos);
    
        imprimirArreglo(a);
    }

    public static void reemplazarSecuencias(char[] arr1, char[] arr2, int inicio1, int inicio2) {
        int fin1, fin2, longitudSecuencia1, longitudSecuencia2, diferenciaLongitudes;
        
        fin1 = obtenerFinSecuencia(arr1, inicio1);
        fin2 = obtenerFinSecuencia(arr2, inicio2);
        
        longitudSecuencia1 = fin1 - inicio1 + 1;
        longitudSecuencia2 = fin2 - inicio2 + 1;
        
        // Si la longitud de la secuencia en B es mayor o igual que la de A se realiza el reemplazo
        if (longitudSecuencia2 >= longitudSecuencia1) {
            // La diferencia de longitudes indica la cantidad de elementos a correr a derecha al reemplazar secuencias
            diferenciaLongitudes = longitudSecuencia2 - longitudSecuencia1;

            // Se corre a derecha la cantidad necesaria de posiciones
            corrimientoADerecha(arr1, fin1, diferenciaLongitudes);
    
            // Se inserta la secuencia del arreglo B en el arreglo A
            insertarSecuencia(arr1, arr2, inicio1, inicio2, longitudSecuencia2);
        } else {
            System.out.println("La secuencia en el arreglo B debe ser mayor o igual que la secuencia en el arreglo A.");
        }
    }

    public static int obtenerFinSecuencia(char[] arr, int pos) {
        while (pos < MAX && arr[pos] != ' ') {
            pos++;
        }
        return pos - 1;
    }

    public static void corrimientoADerecha(char[] arr, int fin, int cantidadElementos) {
        for (int i = 0; i < cantidadElementos; i++) { // Para cada carácter...
            for (int j = MAX - 1; j > i + fin; j--) { // ... correr a derecha
                arr[j] = arr[j-1];
            }
        }
        arr[MAX - 1] = ' '; // Se coloca un separador al final del arreglo
    }

    public static void insertarSecuencia(char[] arr1, char[] arr2, int inicio1, int inicio2, int cantidadElementos) {
        for (int i = 0; i < cantidadElementos; i++) {
            arr1[inicio1 + i] = arr2[inicio2 + i]; 
        }
    }

    public static void imprimirArreglo(char[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.print("\n");
    }
}
