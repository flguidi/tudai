package tp09.e03;

import tp09.e03.comparadores.*;
import tp09.e03.condiciones.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Se instancia un sistema electoral
        SistemaElectoral sistemaElectoral = new SistemaElectoral();

        // Se instancian candidatos y se agregan al sistema
        Candidato gonzales = new Candidato("María González", "Partido Justicialista", "Frente de todos");
        Candidato gomez = new Candidato("Pedro Gómez", "UCR", "Juntos por el cambio");
        Candidato perez = new Candidato("Juan Pérez", "PRO", "Juntos por el cambio");
        sistemaElectoral.agregarCandidato(gonzales);
        sistemaElectoral.agregarCandidato(gomez);
        sistemaElectoral.agregarCandidato(perez);

        // Se instancian mesas (zonas electorales) y se agregan DNIs al padrón
        SitioElectoral mesa1 = new SitioElectoral();
        mesa1.agregarDniPadron(11111111);
        mesa1.agregarDniPadron(22222222);
        mesa1.agregarDniPadron(33333333);

        // Se registran votos
        mesa1.registrarVoto(new Voto(11111111, perez));
        mesa1.registrarVoto(new Voto(22222222, perez));
        mesa1.registrarVoto(new Voto(33333333, gonzales));
        mesa1.registrarVoto(new Voto(44444444, perez)); // No puede votar

        SitioElectoral mesa2 = new SitioElectoral();
        mesa2.agregarDniPadron(44444444);
        mesa2.agregarDniPadron(55555555);
        mesa2.agregarDniPadron(66666666);
        mesa2.registrarVoto(new Voto(44444444, perez));
        mesa2.registrarVoto(new Voto(55555555, gonzales));
        mesa2.registrarVoto(new Voto(66666666, gonzales));

        SitioElectoral mesa3 = new SitioElectoral();
        mesa3.agregarDniPadron(77777777);
        mesa3.agregarDniPadron(88888888);
        mesa3.agregarDniPadron(99999999);
        mesa3.registrarVoto(new Voto(77777777, gonzales));
        mesa3.registrarVoto(new Voto(88888888, perez));
        mesa3.registrarVoto(new Voto(99999999, null));

        // Se instancian escuelas (zonas electorales)
        SitioElectoral escuelaN1 = new SitioElectoral();
        escuelaN1.agregarSitioElectoral(mesa1);
        escuelaN1.agregarSitioElectoral(mesa2);

        SitioElectoral escuelaNormal = new SitioElectoral();
        escuelaNormal.agregarSitioElectoral(mesa3);

        // Se instancia un barrio (zona electoral) y se agrega al sistema electoral
        SitioElectoral barrioCentral = new SitioElectoral();
        barrioCentral.agregarSitioElectoral(escuelaNormal);
        barrioCentral.agregarSitioElectoral(escuelaN1);
        sistemaElectoral.agregarSitioElectoral(barrioCentral);

        // Se cuentan los votos en las mesas, escuelas y barrio
        System.out.println("CANTIDAD DE VOTOS");
        System.out.println("Mesa 1: " + mesa1.contarVotos());
        System.out.println("Mesa 2: " + mesa2.contarVotos());
        System.out.println("Mesa 3: " + mesa3.contarVotos());
        System.out.println("Escuela Normal: " + escuelaNormal.contarVotos());
        System.out.println("Escuela Nro. 1: " + escuelaN1.contarVotos());
        System.out.println("Sistema electoral: " + sistemaElectoral.contarVotos());

        // Filtros y porcentajes
        // Se instancian condiciones
        Condicion condCandidato = new CondicionCandidato("Juan Pérez");
        Condicion condVotoBlanco = new CondicionVotoBlanco();
        Condicion condFecha = new CondicionFecha(LocalDateTime.of(2023, 10, 22, 10, 0),
                                                 LocalDateTime.of(2023, 10, 22, 11, 0));

        // Se realizan filtros
        System.out.println("\nFILTROS");
        System.out.println("Votos de Juan Pérez: " + sistemaElectoral.filtrar(condCandidato));
        System.out.println("Votos en blanco: " + sistemaElectoral.filtrar(condVotoBlanco));
        System.out.println("Votos en rango horario: " + sistemaElectoral.filtrar(condFecha));


        // Se calculan porcentajes
        System.out.println("\nPORCENTAJES (calculados en 'Barrio Central')");
        System.out.print("De votos por candidato: ");
        System.out.println(sistemaElectoral.calcularPorcentaje(condCandidato));

        System.out.print("De votos en blanco: ");
        System.out.println(sistemaElectoral.calcularPorcentaje(condVotoBlanco));

        System.out.print("De votos en rango horario: ");
        System.out.println(sistemaElectoral.calcularPorcentaje(condFecha));

        // Se instancian comparadores y se ordena la lista de candidatos
        Comparator<Candidato> compPartido = new ComparadorPartido();
        Comparator<Candidato> compAgrupacion = new ComparadorAgrupacion();
        Comparator<Candidato> compNombre = new ComparadorNombre();

        ArrayList<Candidato> lista = sistemaElectoral.obtenerCandidatos(
                new ComparadorCompuesto(new ComparadorCompuesto(compPartido, compAgrupacion), compNombre)
        );

        System.out.println("\nLISTA DE CANDIDATOS");
        System.out.println(lista);
    }
}
