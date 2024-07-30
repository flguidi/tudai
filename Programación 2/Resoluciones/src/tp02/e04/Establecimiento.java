package tp02.e04;

public class Establecimiento {
    // Atributos
    private String nombre;
    private Turno[] turnos;
    private int cantidadTurnos;
    private Usuario[] usuarios;
    private int cantidadUsuarios;
    private Cancha[] canchas;
    private int cantidadCanchas;

    // Constructores
    public Establecimiento(String nombre, int limiteUsuarios, int limiteTurnos, int limiteCanchas) {
        this.nombre = nombre;
        this.turnos = new Turno[limiteTurnos];
        this.usuarios = new Usuario[limiteUsuarios];
        this.canchas = new Cancha[limiteCanchas];
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Turno getTurno(int numeroTurno) {
        return turnos[numeroTurno - 1];
    }

    public void reservarTurno(Turno turno) {
        if (!haySuperposicionesCon(turno)) {
            if (this.cantidadTurnos >= this.turnos.length) {
                Turno[] turnosAux = new Turno[this.turnos.length * 2];
                for (int i = 0; i < this.cantidadTurnos; i++)
                    turnosAux[i] = this.turnos[i];
                this.turnos = turnosAux;
            }

            this.turnos[this.cantidadTurnos] = turno;
            this.cantidadTurnos++;
            turno.getUsuario().agregarTurno(turno);
        }
    }

    public void cancelarTurno() {
        if (this.cantidadTurnos > 0) {
            this.turnos[this.cantidadTurnos - 1] = null;
            this.cantidadTurnos--;

            if (this.cantidadTurnos <= this.turnos.length / 2) {
                Turno[] turnosAux = new Turno[this.cantidadTurnos];
                for (int i = 0; i < this.cantidadTurnos; i++)
                    turnosAux[i] = turnos[i];
                this.turnos = turnosAux;
            }
        }
    }

    public boolean haySuperposicionesCon(Turno turno) {
        boolean haySuperposiciones = false;

        for (int i = 0; i < cantidadTurnos; i++) {
            if (turnos[i].seSuperponeCon(turno))
                haySuperposiciones = true;
        }

        return haySuperposiciones;
    }

    public Usuario getUsuario(int numeroUsuario) {
        return usuarios[numeroUsuario - 1];
    }

    public void agregarUsuario(Usuario usuario) {
        if (this.cantidadUsuarios >= this.usuarios.length) {
            Usuario[] usuariosAux = new Usuario[this.usuarios.length * 2];
            for (int i = 0; i < this.cantidadUsuarios; i++)
                usuariosAux[i] = this.usuarios[i];
            this.usuarios = usuariosAux;
        }

        this.usuarios[this.cantidadUsuarios] = usuario;
        this.cantidadUsuarios++;
    }

    public void eliminarUsuario() {
        if (this.cantidadUsuarios > 0) {
            this.usuarios[this.cantidadUsuarios - 1] = null;
            this.cantidadUsuarios--;

            if (this.cantidadUsuarios <= this.usuarios.length / 2) {
                Usuario[] usuariosAux = new Usuario[this.cantidadUsuarios];
                for (int i = 0; i < this.cantidadUsuarios; i++)
                    usuariosAux[i] = usuarios[i];
                this.usuarios = usuariosAux;
            }
        }
    }

    public void agregarCancha(Cancha cancha) {
        if (this.cantidadCanchas >= this.canchas.length) {
            Cancha[] canchasAux = new Cancha[this.canchas.length * 2];
            for (int i = 0; i < this.cantidadCanchas; i++)
                canchasAux[i] = this.canchas[i];
            this.canchas = canchasAux;
        }

        this.canchas[this.cantidadCanchas] = cancha;
        this.cantidadCanchas++;
    }

    public void eliminarCancha() {
        if (this.cantidadCanchas > 0) {
            this.canchas[this.cantidadCanchas - 1] = null;
            this.cantidadCanchas--;

            if (this.cantidadCanchas <= this.canchas.length / 2) {
                Cancha[] canchasAux = new Cancha[this.cantidadCanchas];
                for (int i = 0; i < this.cantidadCanchas; i++)
                    canchasAux[i] = canchas[i];
                this.canchas = canchasAux;
            }
        }
    }
}
