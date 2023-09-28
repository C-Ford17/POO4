package gestionLicencias;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class Licencia implements Cloneable{
    private final String email;
    private LocalDate fechaActivacion;
    private String codigo;
    private List<Transaccion> transacciones;
    private boolean revocada;
    private final String servicio;

    public Licencia(String email, String servicio) {
        this.email = email;
        this.fechaActivacion = LocalDate.now();
        this.codigo = UUID.randomUUID().toString();
        this.transacciones = new LinkedList<>();
        this.revocada = false;
        this.servicio = servicio;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaActivacion() {
        return fechaActivacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public boolean isRevocada() {
        return revocada;
    }

    public String getServicio() {
        return servicio;
    }

    public int getNumTransacciones(){
        return this.transacciones.size();
    }

    public boolean revocar(){
        return this.revocada = true;
    }

    public boolean reactivar(){
        this.revocada = false;
        this.fechaActivacion = LocalDate.now();
        return true;
    }

    protected abstract boolean esAplicable();

    public Transaccion obtenerAutorizacion(){
        if (!isRevocada() || esAplicable()){
            Transaccion transaccion = new Transaccion(this);
            transacciones.add(transaccion);
            return transaccion;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Licencia{" +
                "email='" + email + '\'' +
                ", fechaActivacion=" + fechaActivacion +
                ", codigo='" + codigo + '\'' +
                ", transacciones=" + transacciones +
                ", revocada=" + revocada +
                ", servicio='" + servicio + '\'' +
                '}';
    }

    @Override
    public Licencia clone() throws CloneNotSupportedException {
        Licencia licencia = copiaSuperficial();
        licencia.transacciones = List.copyOf(this.getTransacciones());
        licencia.codigo = UUID.randomUUID().toString();
        return licencia;
    }

    private Licencia copiaSuperficial() throws CloneNotSupportedException {
        Licencia copiasuperficial = ((Licencia) super.clone());
        return copiasuperficial;
    }
}


