package tp05.e03;

public class Main {
    public static final int MINIMO_HECTAREAS = 50;

    public static void main(String[] args) {
        // Se instancia una cooperativa de agricultores
        Cooperativa cooperativa = new Cooperativa("Los trigos");

        // Se instancian lotes
        Lote lote1 = new Lote("lote1", 30);
        Lote lote2 = new Lote("lote2", 40);
        Lote lote3 = new Lote("lote3", 50);

        // Se agregan minerales a los lotes
        lote1.agregarMineral("Hierro");
        lote1.agregarMineral("Cobre");
        lote1.agregarMineral("Zinc");

        lote2.agregarMineral("Hierro");
        lote2.agregarMineral("Aluminio");
        lote2.agregarMineral("Zinc");

        lote3.agregarMineral("Aluminio");
        lote3.agregarMineral("Cobre");
        lote3.agregarMineral("Zinc");

        // Se instancian cereales
        Cereal girasol = new Cereal("Girasol", "Granos de cosecha gruesa");
        Cereal trigo = new Cereal("Trigo", "Granos de cosecha fina");
        Pastura alfalfa = new Pastura("Alfalfa", "Pastura", MINIMO_HECTAREAS);

        // Se agregan minerales necesarios para los cereales
        girasol.agregarMineralNecesario("Hierro");
        girasol.agregarMineralNecesario("Cobre");

        trigo.agregarMineralNecesario("Hierro");
        trigo.agregarMineralNecesario("Zinc");

        alfalfa.agregarMineralNecesario("Aluminio");
        alfalfa.agregarMineralNecesario("Cobre");

        // Se agregan los lotes y cereales a la cooperativa
        cooperativa.agregarLote(lote1);
        cooperativa.agregarLote(lote2);
        cooperativa.agregarLote(lote3);

        cooperativa.agregarCereal(girasol);
        cooperativa.agregarCereal(trigo);
        cooperativa.agregarCereal(alfalfa);

        // Verificaciones
        System.out.println("Se puede sembrar trigo en 'lote1': " + trigo.sePuedeSembrarEn(lote1));
        System.out.println("En 'lote1' se puede sembrar trigo: " + lote1.sePuedeSembrar(trigo));
        System.out.println("Se puede sembrar alfalfa en 'lote2': " + alfalfa.sePuedeSembrarEn(lote2));
        System.out.println("Se puede sembrar alfalfa en 'lote3': " + alfalfa.sePuedeSembrarEn(lote3));

        // Listas de cereales que pueden sembrarse en los lotes
        System.out.println(cooperativa.getCerealesPermitidosEn(lote1));
        System.out.println(cooperativa.getCerealesPermitidosEn(lote2));
        System.out.println(cooperativa.getCerealesPermitidosEn(lote3));

        // Lista de lotes en los que se pueden sembrar un determinado cereal
        System.out.println(cooperativa.getLotesParaCereal(girasol));
        System.out.println(cooperativa.getLotesParaCereal(trigo));
        System.out.println(cooperativa.getLotesParaCereal(alfalfa));

        // Se agregan minerales primarios a la cooperativa
        cooperativa.agregarMineralPrimario("Aluminio");
        cooperativa.agregarMineralPrimario("Cobre");
        cooperativa.agregarMineralPrimario("Zinc");

        // Se verifica si determinados lotes son especiales
        System.out.println("'lote1' es especial: " + cooperativa.esEspecial(lote1));
        System.out.println("'lote2' es especial: " + cooperativa.esEspecial(lote2));
        System.out.println("'lote3' es especial: " + cooperativa.esEspecial(lote3));
    }
}
