package tp02.e02;

import java.time.LocalDateTime;

public class Reunion {
    // Atributos
    private String tema;
    private String lugar;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Contacto[] participantes;
    private int cantidadParticipantes;

    // Constructores
    public Reunion(String tema, String lugar, LocalDateTime fechaInicio, LocalDateTime fechaFin,
                   int limiteParticipantes) {
        this.tema = tema;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new Contacto[limiteParticipantes];
        this.cantidadParticipantes = 0;
    }

    // Métodos
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Contacto getParticipante(int posicionParticipante) {
        return participantes[posicionParticipante - 1];
    }

    public void agregarParticipante(Contacto participante) {
        if (cantidadParticipantes >= this.participantes.length) {
            Contacto[] participantesAux = new Contacto[this.participantes.length * 2];
            for (int i = 0; i < this.cantidadParticipantes; i++)
                participantesAux[i] = this.participantes[i];
            this.participantes = participantesAux;
        }

        this.participantes[this.cantidadParticipantes] = participante;
        this.cantidadParticipantes++;
    }

    public void eliminarParticipante() {
        if (this.cantidadParticipantes > 0) {
            this.participantes[this.cantidadParticipantes - 1] = null;
            this.cantidadParticipantes--;

            if (this.cantidadParticipantes <= this.participantes.length / 2) {
                Contacto[] participantesAux = new Contacto[this.cantidadParticipantes];
                for (int i = 0; i < this.cantidadParticipantes; i++)
                    participantesAux[i] = participantes[i];
                this.participantes = participantesAux;
            }
        }
    }

    public boolean seSuperponeCon(Reunion otraReunion) {
        LocalDateTime inicioOtra = otraReunion.getFechaInicio();
        LocalDateTime finOtra = otraReunion.getFechaFin();

        return (this.fechaInicio.isBefore(finOtra) || this.fechaInicio.isEqual(finOtra))
                && (this.fechaFin.isEqual(inicioOtra) || this.fechaFin.isAfter(inicioOtra));
    }

    @Override
    public String toString() {
        return  "Tema: " + tema +
                " - Lugar: " + lugar +
                " - Fecha de inicio: " + fechaInicio +
                " - Fecha de finalización: " + fechaFin +
                " - Cantidad de participantes: " + this.cantidadParticipantes;
    }
}
