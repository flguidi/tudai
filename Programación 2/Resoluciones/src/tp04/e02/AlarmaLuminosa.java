package tp04.e02;

public class AlarmaLuminosa extends AlarmaSensorial {
    // Atributo específico de subclase
    private Luz luz;

    // Constructores
    public AlarmaLuminosa() {
        super();
        this.luz = new Luz();
    }

    // Métodos
    @Override
    public boolean comprobar() { // Sobreescritura del método comprobar()
        if (super.comprobar())
            this.luz.encender();
        return super.isActivada();
    }
}
