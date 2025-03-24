package tp04.e07;

public class Route {

    private final String name;
    private final int distance;
    private boolean active;

    public Route(String name, int distance, boolean active) {
        this.name = name;
        this.distance = distance;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Ruta " + name + " " +
                distance + "km" +
                (active ? " activa" : " inactiva");
    }

}
