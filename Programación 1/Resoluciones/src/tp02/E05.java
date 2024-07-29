package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 05 --- */

/* 
Escribir un programa que solicite una hora del día (valor entero de la hora solamente) y resuelva en cada caso:
    a. Si la hora está entre las 0 y las 5, pida ingresar la temperatura y si la misma es menor a 20 grados imprima
    “Encender calefacción”. Si es mayor a 25, imprima “Apagar calefacción”. Si está en el rango de 20 a 25 imprima
    “Calefacción encendida, no abrir ventanas”.
    b. Si la hora está entre las 6 y las 11, pida un carácter letra minúscula y si es vocal imprima por la consola
    la cantidad de vocales que tiene la palabra que corresponde con la hora. Ejemplo 8 (ocho) tiene 2 vocales. Si
    no es vocal imprima la cantidad de consonantes que tiene, para el ejemplo 8 (ocho)tiene 2 consonantes.
    c. Si la hora está entre las 12 y 17 y es par, imprima el promedio entre la hora ingresada y el límite inferior
    del rango. Si la hora es impar debe imprimir el promedio entre la hora ingresada y el límite superior del rango.
    d. Si la hora está entre las 18 y 23, pida ingresar una clave numérica, si coincide con la clave almacenada
    previamente en una constante, pida ingresar una segunda clave de verificación (un valor entre 100 y 999).
    Para esta segunda clave (que solo la conoce el usuario) se debe verificar que el el dígito de mayor peso
    (centena) es múltiplo del dígito de mayor peso de la clave almacenada. Si todas estas condiciones se cumplen
    debería mostrar por la consola el mensaje Clave correcta.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E05 {
    public static void main(String[] args) {
        // Declaración de variables, constantes y objetos
        final int CLAVE = 364;
        int hora, vocales = 0, consonantes = 0, claveUsuario1, claveUsuario2;
        float temperatura, promedio;
        char letra;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada de hora
            System.out.print("Ingrese hora (0 a 23): ");
            hora = Integer.valueOf(entrada.readLine());
            
            // Procesamiento y salida
            if (hora >= 0 && hora <= 5) { // a. 00hs-05hs
                System.out.print("Ingrese temperatura: ");
                temperatura = Float.valueOf(entrada.readLine());
                if (temperatura < 20.0) {
                    System.out.println("Encender calefacción");
                } else if (temperatura > 25.0) {
                    System.out.println("Apagar calefacción");
                } else {
                    System.out.println("Calefacción encendida, no abrir ventanas");
                }
            } else if (hora >= 6 && hora <= 11) { // b. 06hs-11hs
                System.out.print("Ingrese una letra minúscula: ");
                letra = entrada.readLine().charAt(0);
                switch (hora) {
                    case 6, 8, 10, 11: 
                        vocales = 2; 
                        consonantes = 2;
                        break;
                    case 7, 9: 
                        vocales = 3;
                        consonantes = 2;
                        break;
                }

                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    System.out.println(hora + " tiene " + vocales + " vocales");
                } else {
                    System.out.println(hora + " tiene " + consonantes + " consonantes");
                }
            } else if (hora >= 12 && hora <= 17) { // c. 12hs-17hs
                if (hora % 2 == 0) {
                    promedio = (float) (hora / 12.0);
                } else {
                    promedio = (float) (hora / 17.0);
                }
                System.out.println("Promedio: " + promedio);
            } else if (hora >= 18 && hora <= 23) { // d. 18hs-23hs
                System.out.print("Ingrese clave numérica: ");
                claveUsuario1 = Integer.valueOf(entrada.readLine());
                if (claveUsuario1 == CLAVE) {
                    System.out.print("Ingrese segunda clave de verificación (número entre 100 y 999): ");
                    claveUsuario2 = Integer.valueOf(entrada.readLine());
                    if ((claveUsuario2 >= 100 && claveUsuario2 <= 999)) {
                        if ((claveUsuario2 / 100) % (CLAVE / 100) == 0) {
                            System.out.println("Clave correcta");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
