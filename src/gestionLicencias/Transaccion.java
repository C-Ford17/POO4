package gestionLicencias;

import java.time.LocalDate;

public class Transaccion implements Cloneable{
    private Licencia licencia;
    private final LocalDate fecha;

    public Transaccion(Licencia licencia) {
        this.licencia = licencia;
        this.fecha = LocalDate.now();
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "Licencia{" +
                "email='" + licencia.getEmail() + '\'' +
                ", servicio='" + licencia.getServicio() + '}' +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public Transaccion clone() throws CloneNotSupportedException {
        Transaccion transaccion = copiaSuperficial();
        transaccion.licencia = this.licencia.clone();
        return transaccion;
    }

    private Transaccion copiaSuperficial() throws CloneNotSupportedException {
        Transaccion copiasuperficial = (Transaccion) super.clone();
        return copiasuperficial;
    }
}
