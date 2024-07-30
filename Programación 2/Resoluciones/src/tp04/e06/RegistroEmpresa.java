package tp04.e06;

import java.util.ArrayList;

public class RegistroEmpresa {
    // Atributos
    private String nombreEmpresa;
    private ArrayList<PersonaAsociada> personasAsociadas;

    // Constructores
    public RegistroEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.personasAsociadas = new ArrayList<>();
    }

    // Métodos
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public ArrayList<PersonaAsociada> getPersonasAsociadas() {
        return new ArrayList<>(personasAsociadas);
    }

    public void agregarPersonaAsociada(PersonaAsociada persona) {
        personasAsociadas.add(persona);
    }

    public void eliminarPersonaAsociada(int indice) {
        if (indice >= 0 && indice < personasAsociadas.size())
            personasAsociadas.remove(indice);
    }

    public void imprimirListado() {
        System.out.println(this.nombreEmpresa.toUpperCase());
        System.out.println("Registro de personas asociadas:");
        System.out.println("--------------------------------");
        for (int i = 0; i < personasAsociadas.size(); i++) {
            System.out.println(personasAsociadas.get(i));
            System.out.println("--------------------------------");
        }
    }
}
