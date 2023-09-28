package gestionLicencias;

public class LicenciaLimitada extends Licencia {
    private final int maximoTransacciones;

    public LicenciaLimitada(String email, String servicio, int maximoTransacciones) {
        super(email, servicio);
        this.maximoTransacciones = maximoTransacciones;
    }

    public int getMaximoTransacciones() {
        return maximoTransacciones;
    }

    public int transaccionesRestantes(){
        return this.maximoTransacciones - getNumTransacciones();
    }

    @Override
    protected boolean esAplicable() {
        return transaccionesRestantes() > 0;
    }

    @Override
    public String toString() {
        return super.toString() + "LicenciaLimitada{" +
                "maximoTransacciones=" + maximoTransacciones +
                '}';
    }

}
