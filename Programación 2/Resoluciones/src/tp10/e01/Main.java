package tp10.e01;

import tp10.e01.criterios_aceptacion.*;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        OfertaLaboral oferta = new OfertaLaboral(30, 300000, "Accenture"); // Oferta laboral
        Candidato candidato = new Candidato("José", "Pérez", "Accenture", 290000); // Candidato

        // CRITERIOS DE ACEPTACIÓN
        System.out.println("¿El candidato acepta la oferta laboral?");

        // 1. Criterio de exclusividad
        CriterioAceptacion cExclusividad = new CriterioExclusividad(candidato.getEmpresa());
        candidato.setCriterioAceptacion(cExclusividad);
        System.out.println("Criterio de exclusividad: " + candidato.aceptaOferta(oferta));

        // 2. Criterio de horas semanales
        CriterioAceptacion cHoras = new CriterioHoras(35);
        candidato.setCriterioAceptacion(cHoras);
        System.out.println("Criterio de horas semanales: " + candidato.aceptaOferta(oferta));

        // 3. Criterio de empresa
        CriterioAceptacion cEmpresa = new CriterioEmpresa("Accenture");
        candidato.setCriterioAceptacion(cEmpresa);
        System.out.println("Criterio de empresa: " + candidato.aceptaOferta(oferta));

        // 4. Criterio de sueldo
        CriterioAceptacion cSueldo = new CriterioSueldo(candidato.getSueldo());
        candidato.setCriterioAceptacion(cSueldo);
        System.out.println("Criterio de sueldo: " + candidato.aceptaOferta(oferta));
    }
}
