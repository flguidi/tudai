package tp03.e04;

import java.util.ArrayList;

public class AgendaCelular {
    // Atributos
    private ArrayList<Contacto> contactos;

    // Constructores
    public AgendaCelular() {
        this.contactos = new ArrayList<>();
    }

    // Métodos
    public Contacto getContacto(int indice) {
        if (indice >= 0 && indice < contactos.size())
            return contactos.get(indice);

        return null;
    }

    public ArrayList<Contacto> getContactos() {
        return new ArrayList<>(contactos);
    }

    public ArrayList<Contacto> getContactosRepetidos() {
        ArrayList<Contacto> contactosRepetidos = new ArrayList<>();

        for (int i = 0; i < contactos.size(); i++) {
            for (int j = i + 1; j < contactos.size(); j++) {
                Contacto contacto1 = contactos.get(i);
                Contacto contacto2 = contactos.get(j);

                if (contacto1.equals(contacto2)) {
                    if (!contactosRepetidos.contains(contacto1))
                        contactosRepetidos.add(contacto1);

                    if (!contactosRepetidos.contains(contacto2))
                        contactosRepetidos.add(contacto2);
                }
            }
        }

        return contactosRepetidos;
    }

    public void agendarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public void eliminarContacto(int indice) {
        if (indice >= 0 && indice < contactos.size())
            this.contactos.remove(indice);
    }

    public String obtenerInformacionContactos(ArrayList<Contacto> contactos) {
        String informacion = "";
        for (Contacto contacto : contactos)
            informacion += contacto + "\n";
        return informacion;
    }

    public double calcularPromedioEdades() {
        int edadTotal = 0;
        for (Contacto contacto : contactos)
            edadTotal += contacto.getEdad();
        return (double) edadTotal / contactos.size();
    }

    @Override
    public String toString() {
        return "|AGENDA|\n" +
                "Cantidad de contactos agendados: " + contactos.size() + "\n" +
                "Contactos:\n" + obtenerInformacionContactos(contactos) +
                "Edad promedio: " + calcularPromedioEdades() + "\n" +
                "Contactos repetidos:\n" + obtenerInformacionContactos(getContactosRepetidos());
    }
}
