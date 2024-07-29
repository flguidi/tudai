package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Ejercicio tipo parcial 01 --- */

/*
Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la
de eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por ejemplo,
artículos (el, la, las, los...), preposiciones (a, ante, con, por...), etc. Dado un texto almacenado en un
arreglo de caracteres de tamaño MAX_A, donde cada palabra está delimitada por espacios, comas (,) o puntos (.)
se pide eliminar todas las stopwords almacenadas en otro arreglo de caracteres de tamaño MAX_S que se encuentra
delimitado por espacios.
*/

public class EjercicioTipoParcial01 {
	public static final int MAX_A = 42, MAX_S = 20;
	public static final char S1 = ' ', S2 = ',', S3 = '.';

	public static void main(String[] args) {
		char[] arrA = {' ', 'l', 'a', ' ', 'c', 'a', 's', 'a', ' ', 'r', 'o', 'j', 'a',
				',', ' ',  'a', ' ', 'l', 'a', ' ', 'v', 'u', 'e', 'l', 't', 'a', ' ',
				'd', 'e', ' ', 'l', 'a', ' ', 'e', 's', 'q', 'u', 'i', 'n', 'a', '.', ' '};
		char[] arrS = {' ', 'a', ' ', 'l', 'a', ' ', 'l', 'o', 's', ' ', 'd', 'e', ' ',
				'l', 'a', ' ', 'l', 'a', 's', ' '};
		int iniA = 0, finA = -1;
		
        imprimirArreglo(arrA);

		while (iniA < MAX_A) {
			iniA = obtenerInicio(arrA, finA + 1, MAX_A);
			if (iniA < MAX_A) {
				finA = obtenerFin(arrA, iniA, MAX_A);
				if (esStopword(arrA, iniA, finA, arrS)) {
					eliminarPalabra(arrA, iniA, finA);
					finA = iniA;
				}
			}
		}

        imprimirArreglo(arrA);
	}

	public static boolean esStopword(char[] arrA, int iniA, int finA, char[] arrS) {
		int iniS = 0, finS = -1, largoSecuencia, largoStopword;
        boolean esStopword = false;

		while (iniS < MAX_S && !esStopword) {
			iniS = obtenerInicio(arrS, finS + 1, MAX_S);					
			
			if (iniS < MAX_S) {
				finS = obtenerFin(arrS, iniS, MAX_S);
				
                largoSecuencia = finA - iniA + 1;
                largoStopword = finS - iniS + 1;

				if (largoSecuencia == largoStopword && sonIguales(arrA, iniA, finA, arrS, iniS)) {
					esStopword = true;
				}
			}
		}

		return esStopword;			
	}	

	public static boolean sonIguales(char[] arrA, int iniA, int finA, char[] arrS, int iniS) {
		while (iniA <= finA && arrA[iniA] == arrS[iniS]) {
			iniA++;
			iniS++;
		}

		return iniA > finA;
	}

	public static void eliminarPalabra(char[] arr, int ini, int fin) {
		for (int i = ini; i <= fin; i++) {
			eliminarElemento(arr, ini);
		}
	}

	public static void eliminarElemento(char[] arr, int pos) {
		for (int i = pos; i < MAX_A - 1; i++) {
			arr[i] = arr[i + 1];
		}
	}

	public static void imprimirArreglo(char[] arr) {
		for (int i = 0; i < MAX_A; i++) {
			System.out.print(arr[i]);
		}
	}

	public static int obtenerInicio(char[] arr, int pos, int largo) {
		while (pos < largo && (arr[pos] == S1 || arr[pos] == S2 || arr[pos] == S3)) {
			pos++;
		}
		return pos;
	}

	public static int obtenerFin(char[] arr, int pos, int largo) {
		while (pos < largo && (arr[pos] != S1 && arr[pos] != S2 && arr[pos] != S3)) {
			pos++;
		}
		return pos - 1;
	}
}
