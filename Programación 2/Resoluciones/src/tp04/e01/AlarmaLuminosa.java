package tp04.e01;

public class AlarmaLuminosa extends Alarma {
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
        if (super.comprobar()) {
            this.luz.encender();
            return true;
        }
        return false;
    }
}
