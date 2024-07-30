package tp01.e04;

public class Rectangulo {
    // Atributos
    private PuntoGeometrico puntoA;
    private PuntoGeometrico puntoB;
    private PuntoGeometrico puntoC;
    private PuntoGeometrico puntoD;
    private double ancho;
    private double alto;

    // Constructores
    public Rectangulo(PuntoGeometrico puntoSupIzq, PuntoGeometrico puntoInfDer) {
        this.puntoA = puntoSupIzq;
        this.puntoB = new PuntoGeometrico(puntoInfDer.getX(), puntoSupIzq.getY());
        this.puntoC = puntoInfDer;
        this.puntoD = new PuntoGeometrico(puntoSupIzq.getX(), puntoInfDer.getY());
        this.ancho = this.obtenerAncho();
        this.alto = this.obtenerAlto();
    }

    public Rectangulo(PuntoGeometrico puntoSupIzq, double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.puntoA = puntoSupIzq;
        this.puntoB = new PuntoGeometrico(puntoA.getX() + ancho, puntoA.getY());
        this.puntoC = new PuntoGeometrico(puntoB.getX(), puntoB.getY() - alto);
        this.puntoD = new PuntoGeometrico(puntoC.getX() - ancho, puntoC.getY());
    }

    // Métodos
    public PuntoGeometrico getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(PuntoGeometrico puntoA) {
        this.puntoA = puntoA;
    }

    public PuntoGeometrico getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(PuntoGeometrico puntoB) {
        this.puntoB = puntoB;
    }

    public PuntoGeometrico getPuntoC() {
        return puntoC;
    }

    public void setPuntoC(PuntoGeometrico puntoC) {
        this.puntoC = puntoC;
    }

    public PuntoGeometrico getPuntoD() {
        return puntoD;
    }

    public void setPuntoD(PuntoGeometrico puntoD) {
        this.puntoD = puntoD;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    private double obtenerAncho() {
        return puntoA.calcularDistancia(puntoB);
    }

    public double obtenerAlto() {
        return puntoB.calcularDistancia(puntoC);
    }

    public double calcularArea() {
        return alto * ancho;
    }

    public int compararArea(Rectangulo otroRectangulo) {
        if (this.calcularArea() > otroRectangulo.calcularArea())
            return 1;
        else if (this.calcularArea() == otroRectangulo.calcularArea())
            return 0;
        else
            return -1;
    }

    public boolean esCuadrado() {
        return alto == ancho;
    }

    public double obtenerLargoLadoSuperior() {
        return ancho;
    }

    public String obtenerOrientacion() {
        if (ancho > alto)
            return "Acostado";
        else if (ancho < alto)
            return "Parado";
        else
            return "Es cuadrado";
    }

    public void desplazar(double desplazamientoX, double desplazamientoY) {
        puntoA.desplazar(desplazamientoX, desplazamientoY);
        puntoB.desplazar(desplazamientoX, desplazamientoY);
        puntoC.desplazar(desplazamientoX, desplazamientoY);
        puntoD.desplazar(desplazamientoX, desplazamientoY);
    }
}