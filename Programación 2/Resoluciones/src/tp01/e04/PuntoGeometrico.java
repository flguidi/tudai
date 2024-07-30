package tp01.e04;

public class PuntoGeometrico {
    // Atributos
    private double x;
    private double y;

    // Constructores
    public PuntoGeometrico() {
        this(0, 0);
    }

    public PuntoGeometrico(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String obtenerStringCoordenadas() {
        return ("(" + this.getX() + "; " + this.getY() + ")");
    }

    public void desplazar(double desplazamientoX, double desplazamientoY) {
        this.setX(this.x + desplazamientoX);
        this.setY(this.y + desplazamientoY);
    }

    public double calcularDistancia(PuntoGeometrico otroPunto) {
        double distanciaX = this.getX() - otroPunto.getX();
        double distanciaY = this.getY() - otroPunto.getY();
        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    }
}
