package tp01.e01;

import java.time.LocalDate;

public class Persona {
    // Atributos
    private String nombre;
    private String apellido;
    private int dni;
    private String sexo;
    private LocalDate fechaNacimiento;
    private int edad;
    private double peso;
    private double altura;

    // Constructores
    public Persona(int dni) {
        this.nombre = "N";
        this.apellido = "N";
        this.edad = 1;
        this.fechaNacimiento = LocalDate.of(2000, 1, 1);
        this.dni = dni;
        this.sexo = "Femenino";
        this.peso = 1;
        this.altura = 1;
    }

    public Persona(int dni, String nombre, String apellido) {
        this(dni);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(int dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this(dni, nombre, apellido);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(int dni, String nombre, String apellido, LocalDate fechaNacimiento,
                   int edad, String sexo) {
        this(dni, nombre, apellido, fechaNacimiento);
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(int dni, String nombre, String apellido, LocalDate fechaNacimiento,
                   int edad, String sexo, double peso, double altura) {
        this(dni, nombre, apellido, fechaNacimiento, edad, sexo);
        this.peso = peso;
        this.altura = altura;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean estaCumpliendoAnios() {
        LocalDate fechaHoy = LocalDate.now();
        return fechaHoy.getMonthValue() == this.fechaNacimiento.getMonthValue()
                && fechaHoy.getDayOfMonth() == this.fechaNacimiento.getDayOfMonth();
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public boolean puedeVotar() {
        return edad >= 16;
    }

    public boolean tieneEdadCoherente() {
        int anioNacimiento = fechaNacimiento.getYear();
        int anioActual = LocalDate.now().getYear();
        return anioNacimiento + edad == anioActual;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / Math.pow(altura, 2);
    }

    public boolean estaEnForma() {
        double imc = calcularIMC();
        return imc >= 18.5 && imc <= 25;
    }

    public void mostrarInformacion() {
        System.out.println(
                "INFORMACIÓN: " +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDni: " + dni +
                "\nFecha de nacimiento: " + fechaNacimiento +
                "\nEdad: " + edad +
                "\nSexo: " + sexo +
                "\nPeso: " + peso +
                "\nAltura: " + altura
        );
    }
}
