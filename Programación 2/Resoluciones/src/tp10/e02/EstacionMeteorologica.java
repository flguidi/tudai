package tp10.e02;

import java.util.ArrayList;

public class EstacionMeteorologica {
    // Atributos
    private String ciudad;
    private ArrayList<Sensor> sensores;

    // Constructores
    public EstacionMeteorologica(String ciudad) {
        this.ciudad = ciudad;
        this.sensores = new ArrayList<>();
    }

    // Métodos
    public String getCiudad() {
        return ciudad;
    }

    public void agregarSensor(Sensor sensor) {
        if (!this.sensores.contains(sensor))
            this.sensores.add(sensor);
    }

    public boolean predecirLluvia() {
        for (Sensor s : this.sensores) {
            if (s.predecirLluvia())
                return true; // Lloverá
        }
        return false; // No lloverá
    }
}
