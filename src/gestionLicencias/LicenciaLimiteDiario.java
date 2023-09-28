package gestionLicencias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LicenciaLimiteDiario extends LicenciaLimitada {
    private final int maximoTransaccionesDia;
    private Map<Integer, Integer> cantidadTransaccionesDia;
    private static int hoy;

    public LicenciaLimiteDiario(String email, String servicio, int maximoTransacciones, int maximoTransaccionesDia) {
        super(email, servicio, maximoTransacciones);
        this.maximoTransaccionesDia = maximoTransaccionesDia;
        this.cantidadTransaccionesDia = new HashMap<>();
    }

    @Override
    protected boolean esAplicable() {
        if (!this.cantidadTransaccionesDia.isEmpty()) return this.cantidadTransaccionesDia.get(hoy) < maximoTransaccionesDia || super.esAplicable();
        return true;
    }

    public int transaccionesRestantesHoy() {
        if (!this.cantidadTransaccionesDia.isEmpty()) return this.maximoTransaccionesDia - this.cantidadTransaccionesDia.get(hoy);
        return maximoTransaccionesDia;
    }

    public int transaccionesEnDia(int dia) {
        return this.cantidadTransaccionesDia.get(dia);
    }

    @Override
    public Transaccion obtenerAutorizacion() {
        Transaccion transaccion = super.obtenerAutorizacion();
        int dia = transaccion.getFecha().getDayOfYear();
        cantidadTransaccionesDia.put(dia, +1);
        return transaccion;

    }

    @Override
    public String toString() {
        return super.toString() + "LicenciaLimiteDiario{" +
                "maximoTransaccionesDia=" + maximoTransaccionesDia +
                ", cantidadTransaccionesDia=" + cantidadTransaccionesDia +
                '}';
    }

}
