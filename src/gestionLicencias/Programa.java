package gestionLicencias;

import java.util.LinkedList;

public class Programa {
    public static void main(String[] args) throws CloneNotSupportedException {
        Licencia licenciaTemporal = new LicenciaTemporal("juan@um.es","http://api.um.es/disco/v1/",1);
        Licencia licenciaLimitada = new LicenciaLimitada("pepe@um.es","http://api.um.es/disco/v1/",3);
        Licencia licenciaLimiteDiario = new LicenciaLimiteDiario("paco@um.es","http://api.um.es/disco/v1/",4,1);
        LinkedList<Licencia> licencias = new LinkedList<>();
        licencias.add(licenciaLimitada);
        licencias.add(licenciaTemporal);
        licencias.add(licenciaLimiteDiario);
        System.out.println("licencias al inicio");
        for (Licencia licencia:licencias) {
            System.out.println(licencia);
        }
        for (Licencia licencia:licencias) {
            if (licencia instanceof LicenciaLimiteDiario) System.out.println(((LicenciaLimiteDiario) licencia).transaccionesRestantesHoy());
            if (licencia instanceof LicenciaTemporal) ((LicenciaTemporal) licencia).revocar();
        }
        for (Licencia licencia:licencias) {
            Transaccion transaccion = licencia.obtenerAutorizacion();
            if (transaccion == null) System.out.println("no autorizada");
            else System.out.println(transaccion);
            Transaccion transaccion1 = licencia.obtenerAutorizacion();
            if (transaccion1 == null) System.out.println("no autorizada");
            else System.out.println(transaccion1);
            Transaccion transaccion2 = licencia.obtenerAutorizacion();
            if (transaccion2 == null) System.out.println("no autorizada");
            else System.out.println(transaccion2);
            Transaccion transaccion3 = licencia.obtenerAutorizacion();
            if (transaccion3 == null) System.out.println("no autorizada");
            else System.out.println(transaccion3);

        }
        System.out.println("licencias despues de cambios");
        for (Licencia licencia:licencias) {
            System.out.println(licencia);
        }
        LinkedList<Licencia> copias = new LinkedList<>();
        for (Licencia licencia:licencias) {
            copias.add(licencia.clone());
        }
        System.out.println("copias");
        for (Licencia licenciacopia:copias) {
            System.out.println(licenciacopia);
        }
    }
}
