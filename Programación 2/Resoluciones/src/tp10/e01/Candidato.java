package tp10.e01;

import tp10.e01.criterios_aceptacion.CriterioAceptacion;

public class Candidato {
    // Atributos
    private String nombre;
    private String apellido;
    private String empresa;
    private double sueldo;
    private CriterioAceptacion criterioAceptacion;

    // Constructores
    public Candidato(String nombre, String apellido, String empresa, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.sueldo = sueldo;
        this.criterioAceptacion = null;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setCriterioAceptacion(CriterioAceptacion criterioAceptacion) {
        this.criterioAceptacion = criterioAceptacion;
    }

    public boolean aceptaOferta(OfertaLaboral oferta) {
        return this.criterioAceptacion.acepta(oferta);
    }
}
