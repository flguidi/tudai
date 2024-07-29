package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Bonus Track 01 --- */

/* 
La clínica “Dolores” tiene un sistema de historias clínicas para todos sus pacientes. El gerente de administración
solicita emitir algunos informes y elige en un menú de opciones:
    a. Si la opción es ‘1’ se debe pedir ingrese la cantidad de pacientes (no mayor a 15) y por cada uno solicitar
       la edad. Informar cuántos pacientes son mayores de 78 años.
    b. Si la opción es ‘2’ se debe ingresar una cantidad de prestadores de servicios que tiene la clínica (no mayor
       a 10). Por cada prestador solicitar la cantidad de pacientes que ha atendido en los últimos 2 días. Finalmente,
       informar cuántos prestadores han atendido a más de 10 pacientes en los últimos 2 días.
    c. Si la opción es ‘3’ se desea saber la cantidad de pacientes de cada sexo y el promedio de edades de cada grupo.
       Para ello deberá solicitar primero que ingrese qué cantidad son femeninos (no mayor a 10) y qué cantidad son
       masculinos (no mayor a 10). Por cada grupo solicitar el ingreso de las edades para luego informar los promedios
       correspondientes.
    d. Por último, si la opción es ‘4’ se desea conocer cuántos pacientes no tienen obra social. Para ello se debe
       solicitar la cantidad de pacientes (no mayor a 15) y por cada uno solicitar si tiene o no obra social. Puede
       suponer un valor numérico para verdadero y otro para falso.
    e. Cualquier otra opción se debe informar que “No es una opción válida” y debe volver a pedirla. Con ‘0’ termina.
       Escribir un programa que permita obtener al gerente de administración los informes que necesita.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT01 {
    public static void main(String[] args) {
        final int MAXPACIENTES = 15, MAXPRESTADORES = 10, MAXFEMENINOS = 10, MAXMASCULINOS = 10;
        int opcion, cantidadPacientes, edadPaciente, mayoresDe78 = 0, cantidadPrestadores, masDe10Pacientes = 0;
        int cantidadFemeninos, cantidadMasculinos, edadFemeninos = 0, edadMasculinos = 0; 
        float promedioFemeninos, promedioMasculinos;
        int tieneOS, totalConOS = 0;
        boolean seguir = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (seguir) {
            try {
                // Menú
                System.out.println("Ingrese una opción: ");
                System.out.println("1. Cantidad de pacientes mayores a 78 años ");
                System.out.println("2. Cantidad de prestadores de servicios con más de 10 pacientes");
                System.out.println("3. Cantidad de pacientes según sexo, y promedio de edades");
                System.out.println("4. Cantidad de pacientes sin obra social");
                System.out.println("0. Finalizar");
                opcion = Integer.valueOf(entrada.readLine());

                switch (opcion) {
                    case 1:
                        // Entrada de cantidad de pacientes
                        System.out.print("Ingresar cantidad de pacientes (como máximo "+ MAXPACIENTES +"): ");
                        cantidadPacientes = Integer.valueOf(entrada.readLine());

                        // Procesamiento
                        if (cantidadPacientes >= 0 && cantidadPacientes <= MAXPACIENTES) {
                            for (int paciente = 1; paciente <= cantidadPacientes; paciente++) {
                                System.out.print("Ingrese la edad del paciente " + paciente + ": ");
                                edadPaciente = Integer.valueOf(entrada.readLine());
                                if (edadPaciente > 78) {
                                    mayoresDe78++;
                                }
                            }

                            // Salida
                            System.out.println("Cantidad de pacientes mayores de 78 años: " + mayoresDe78);
                        } else {
                            System.out.println("Entrada incorrecta.");
                        }
                        break;

                    case 2:
                        // Entrada de cantidad de prestadores de servicios
                        System.out.print("Ingrese cantidad de prestadores de servicios (como máximo " + MAXPRESTADORES + "): ");
                        cantidadPrestadores = Integer.valueOf(entrada.readLine());
                        
                        // Procesamiento
                        if (cantidadPrestadores >= 0 && cantidadPrestadores <= MAXPRESTADORES) {
                            for (int prestador = 1; prestador <= cantidadPrestadores; prestador++) {
                                System.out.print("Ingrese la cantidad de pacientes del prestador " + prestador + ": ");
                                cantidadPacientes = Integer.valueOf(entrada.readLine());
                                if (cantidadPacientes > 10) {
                                    masDe10Pacientes++;
                                }
                            }

                            // Salida
                            System.out.println("Cantidad de prestadores con más de 10 pacientes: " + masDe10Pacientes);
                        } else {
                            System.out.println("Entrada incorrecta.");
                        }
                        break;
                    
                        case 3:
                            // Cantidad de pacientes masculinos y femeninos
                            System.out.print("Ingresar cantidad de pacientes masculinos (como máximo " + MAXMASCULINOS + "): ");
                            cantidadMasculinos = Integer.valueOf(entrada.readLine());
                            System.out.print("Ingresar cantidad de pacientes femeninos (como máximo " + MAXFEMENINOS + "): ");
                            cantidadFemeninos = Integer.valueOf(entrada.readLine());

                            if (cantidadMasculinos >= 0 && cantidadMasculinos <= MAXMASCULINOS 
                                && cantidadFemeninos >= 0 && cantidadMasculinos <= MAXFEMENINOS) {
                                // Entrada de edad de masculinos
                                for (int masc = 1; masc <= cantidadMasculinos; masc++) {
                                    System.out.print("Edad del paciente masculino " + masc + ": ");
                                    edadPaciente = Integer.valueOf(entrada.readLine());
                                    edadMasculinos += edadPaciente;
                                }

                                // Entrada de edad de femeninos
                                for (int fem = 1; fem <= cantidadFemeninos; fem++) {
                                    System.out.print("Edad del paciente femenino " + fem + ": ");
                                    edadPaciente = Integer.valueOf(entrada.readLine());
                                    edadFemeninos += edadPaciente;
                                }

                                // Procesamiento
                                promedioMasculinos = (float) edadMasculinos / cantidadMasculinos;
                                promedioFemeninos =  (float) edadFemeninos / cantidadFemeninos;

                                // Salida
                                System.out.println("Edad promedio de pacientes masculinos: " + promedioMasculinos);
                                System.out.println("Edad promedio de pacientes femeninos: " + promedioFemeninos);

                            } else {
                                System.out.println("Entrada incorrecta");
                            }
                        break;

                    case 4:
                        // Entrada de cantidad de pacientes
                        System.out.print("Ingresar cantidad de pacientes (como máximo "+ MAXPACIENTES +"): ");
                        cantidadPacientes = Integer.valueOf(entrada.readLine());
                        
                        // Procesamiento
                        if (cantidadPacientes >= 0 && cantidadPacientes <= MAXPACIENTES) {
                            for (int paciente = 1; paciente <= cantidadPacientes; paciente++) {
                                System.out.print("¿El paciente " + paciente + " tiene obra social? (0 para no, 1 para sí) ");
                                tieneOS = Integer.valueOf(entrada.readLine());
                                if (tieneOS == 0 || tieneOS == 1) {
                                    totalConOS += tieneOS; 
                                } else {
                                    System.out.println("Entrada incorrecta.");
                                }
                            }

                            // Salida
                            System.out.println("Cantidad de pacientes con obra social: " + totalConOS);
                        }
                        break;

                    case 0:
                        seguir = false;
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("Error. Volviendo al menú.");
            }

        }
    }
}
