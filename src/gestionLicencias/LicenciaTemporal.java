package gestionLicencias;

import java.time.LocalDate;

public class LicenciaTemporal extends Licencia{
    LocalDate fechaCaducidad;

    public LicenciaTemporal(String email, String servicio, int mesesACaducar) {
        super(email, servicio);
        this.fechaCaducidad = super.getFechaActivacion().plusMonths(mesesACaducar);
    }

    public LicenciaTemporal(String email, String servicio){
        this(email,servicio,3);
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    public boolean isCaducada(){
        return LocalDate.now().isBefore(getFechaCaducidad());
    }

    public void extenderFechaCaducidad(int meses){
            this.fechaCaducidad.plusMonths(meses);
    }

    @Override
    protected boolean esAplicable() {
        if (!isCaducada()){
            super.obtenerAutorizacion();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "LicenciaTemporal{" +
                "fechaCaducidad=" + fechaCaducidad +
                '}';
    }

}


