package tp02.e03;

public class Main {
    public static void main(String[] args) {
        // Se crea un país
        Pais pais = new Pais("País", 5);

        // Se añaden provincias al país
        pais.agregarProvincia(new Provincia("Provincia 1", 10));
        pais.agregarProvincia(new Provincia("Provincia 2", 12));

        // Se añaden ciudades a 'Provincia 1'
        pais.getProvincia(1).agregarCiudad(new Ciudad("Ciudad 1", 120000, 5, 200000));
        pais.getProvincia(1).agregarCiudad(new Ciudad("Ciudad 2", 150000, 5, 230000));
        pais.getProvincia(1).agregarCiudad(new Ciudad("Ciudad 3", 90000, 5, 500000));

        // Se añaden impuestos a 'Ciudad 1'
        pais.getProvincia(1).getCiudad(1).agregarImpuesto(new Impuesto("Impuesto 1", 30000));
        pais.getProvincia(1).getCiudad(1).agregarImpuesto(new Impuesto("Impuesto 2", 50000));
        pais.getProvincia(1).getCiudad(1).agregarImpuesto(new Impuesto("Impuesto 3", 70000));
        pais.getProvincia(1).getCiudad(1).agregarImpuesto(new Impuesto("Impuesto 4", 60000));
        pais.getProvincia(1).getCiudad(1).agregarImpuesto(new Impuesto("Impuesto 5", 5000));

        // Cálculo de déficit de 'Provincia 1'
        int cantCiudades = pais.getProvincia(1).getCantidadCiudades();
        int cantCiudadesEnDeficit = pais.getProvincia(1).getCantCiudadesEnDeficit();
        boolean mayoriaCiudadesEnDeficit = cantCiudades / 2 <= cantCiudadesEnDeficit;
        String nombreCiudadesEnDeficit = pais.getProvincia(1).getNombreCiudadesEnDeficit();

        System.out.println("\n'Provincia 1': ");
        System.out.println("Cantidad de ciudades: " + cantCiudades);
        System.out.println("Cantidad de ciudades en déficit: " + cantCiudadesEnDeficit);
        System.out.println("Ciudades en déficit: " + nombreCiudadesEnDeficit);
        System.out.println("'Provincia 1' tiene más de la mitad de ciudades en déficit: " + mayoriaCiudadesEnDeficit);

        // Cálculo de déficit de 'Ciudad 1'
        int poblacion = pais.getProvincia(1).getCiudad(1).getPoblacion();
        double totalImpuestos = pais.getProvincia(1).getCiudad(1).getTotalImpuestos();
        double gastosMantenimiento = pais.getProvincia(1).getCiudad(1).getGastosMantenimiento();
        boolean estaEnDeficit = pais.getProvincia(1).getCiudad(1).estaEnDeficit();

        System.out.println("\n'Ciudad 1':");
        System.out.println("Población: " + poblacion);
        System.out.println("Total recaudado: " + totalImpuestos);
        System.out.println("Gastos en mantenimiento: " + gastosMantenimiento);
        System.out.println("Está en déficit: " + estaEnDeficit);
    }
}
