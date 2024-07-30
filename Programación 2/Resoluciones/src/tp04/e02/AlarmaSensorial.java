package tp04.e02;

import java.util.ArrayList;

public class AlarmaSensorial {
    // Atributos
    private boolean activada;
    private Timbre timbre;
    private ArrayList<Sensor> sensores;

    // Constructores
    public AlarmaSensorial() {
        this.activada = false;
        this.timbre = new Timbre();
        this.sensores = new ArrayList<>();
    }

    // Métodos
    public boolean isActivada() {
        return activada;
    }

    public ArrayList<Sensor> getSensores() {
        return new ArrayList<>(this.sensores);
    }

    public void agregarSensor(Sensor sensor) {
        if (!this.sensores.contains(sensor))
            this.sensores.add(sensor);
    }

    public void eliminarSensor(int indice) {
        if (indice >= 0 && indice < sensores.size())
            sensores.remove(indice);
    }

    public boolean comprobar() {
        for (Sensor sensor : sensores) {
            if (sensor.comprobarZona())
                this.activada = true;
        }

        if (this.activada) {
            System.out.println("Zonas:");
            for (Sensor sensor : sensores) {
                if (sensor.comprobarZona())
                    System.out.print(sensor.getZona() + " ");
            }
            System.out.print("\n");
            this.timbre.hacerSonar();
        }

        return this.activada;
    }
}
