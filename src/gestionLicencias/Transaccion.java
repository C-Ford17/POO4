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

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
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
                ", codigo='" + licencia.getCodigo() + '}' +
                ", fecha=" + fecha +
                '}';
    }
}
