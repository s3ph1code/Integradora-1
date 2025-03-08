package model;


import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario {
    private String contacto;

    private List<Ruta> rutasAsignadas;

    public Pasajero(String id, String nombre, String tipo, String contacto) {
        super(id, nombre, tipo);
        this.contacto = contacto;
        this.rutasAsignadas = new ArrayList<>();
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<Ruta> getRutasAsignadas() {
        return rutasAsignadas;
    }

    public void setRutasAsignadas(List<Ruta> rutasAsignadas) {
        this.rutasAsignadas = rutasAsignadas;
    }

    // Métodos del diagrama
    public void registrarPasaj() {
        // TODO: Implementar lógica de registro de pasajero
    }

    public void consultarPasaj() {
        // TODO: Implementar lógica de consulta de pasajero
    }

    public void reportePasaj() {
        // TODO: Implementar generación de reporte para pasajero
    }
}
