package tp01.e03;

public class Rectangulo {
    // Atributos
    private PuntoGeometrico puntoA;
    private PuntoGeometrico puntoB;
    private PuntoGeometrico puntoC;
    private PuntoGeometrico puntoD;

    // Constructores
    public Rectangulo(PuntoGeometrico puntoSupIzq, PuntoGeometrico puntoInfDer) {
        this.puntoA = puntoSupIzq;
        this.puntoB = new PuntoGeometrico(puntoInfDer.getX(), puntoSupIzq.getY());
        this.puntoC = puntoInfDer;
        this.puntoD = new PuntoGeometrico(puntoSupIzq.getX(), puntoInfDer.getY());
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

    private double obtenerAncho() {
        return puntoA.calcularDistancia(puntoB);
    }

    public double obtenerAlto() {
        return puntoB.calcularDistancia(puntoC);
    }

    public double calcularArea() {
        return this.obtenerAncho() * this.obtenerAlto();
    }

    public int compararArea(Rectangulo otroRectangulo) {
        double areaRectangulo = this.calcularArea();
        double areaOtroRectangulo = otroRectangulo.calcularArea();

        if (areaRectangulo > areaOtroRectangulo)
            return 1;
        else if (areaRectangulo == areaOtroRectangulo)
            return 0;
        else
            return -1;
    }

    public boolean esCuadrado() {
        return this.obtenerAncho() == this.obtenerAlto();
    }

    public double obtenerLargoLadoSuperior() {
        return puntoC.calcularDistancia(puntoD);
    }

    public String obtenerOrientacion() {
        double ancho = this.obtenerAncho();
        double alto = this.obtenerAlto();

        if (ancho > alto)
            return "Acostado";
        else if (ancho < alto)
            return "Parado";
        else
            return "Es cuadrado";
    }

    public void desplazar(double desplazamientoX, double desplazamientoY) {
        this.puntoA.desplazar(desplazamientoX, desplazamientoY);
        this.puntoB.desplazar(desplazamientoX, desplazamientoY);
        this.puntoC.desplazar(desplazamientoX, desplazamientoY);
        this.puntoD.desplazar(desplazamientoX, desplazamientoY);
    }
}
