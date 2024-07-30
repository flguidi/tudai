package tp07.e01;

import tp07.e01.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancia un sistema agrícola
        SistemaAgricola sistemaAgricola = new SistemaAgricola();

        // Se instancian enfermedades y se agregan estados patológicos
        Enfermedad e1 = new Enfermedad("Cochinilla");
        e1.agregarEstadoPatologico("Deshidratación");
        e1.agregarEstadoPatologico("Hojas amarillas");

        // Se instancian cultivos y se agregan enfermedades frecuentes
        Cultivo c1 = new Cultivo("Girasol");
        c1.agregarEnfermedadFrecuente(e1);

        // Se instancian agroquímicos y se agregan estados patologicos que tratan
        Agroquimico a1 = new Agroquimico("Insecticida");
        a1.agregarEstadoPatologicoTratable("Deshidratación");
        a1.agregarEstadoPatologicoTratable("Hojas amarillas");

        Agroquimico a2 = new Agroquimico("Herbicida");
        a2.agregarEstadoPatologicoTratable("Hojas amarillas");
        a2.agregarEstadoPatologicoTratable("Caída prematura de frutos");

        Agroquimico a3 = new Agroquimico("Funguicida");
        a3.agregarEstadoPatologicoTratable("Deshidratación");
        a3.agregarEstadoPatologicoTratable("Hojas amarillas");
        a3.agregarCultivoDesaconsejado(c1);

        // Se añaden los elementos al sistema
        sistemaAgricola.agregarAgroquimico(a1);
        sistemaAgricola.agregarAgroquimico(a2);
        sistemaAgricola.agregarAgroquimico(a3);

        sistemaAgricola.agregarCultivo(c1);

        // Se instancian condiciones y se imprimen listados
        Condicion cond1 = new CondicionEnfermedad(e1);
        Condicion cond2 = new CondicionCultivo(c1);

        System.out.print("Agroquímicos que tratan " + e1 + ": ");
        System.out.println(sistemaAgricola.obtenerAgroquimicos(cond1));
        System.out.print("Agroquímicos que tratan " + e1 + " y pueden utilizarse en " + c1 + ": ");
        System.out.println(sistemaAgricola.obtenerAgroquimicos(new CondicionAnd(cond1, cond2)));
    }
}
