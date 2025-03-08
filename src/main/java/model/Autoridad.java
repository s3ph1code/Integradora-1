package model;


public class Autoridad extends Usuario {
    private String rol;

    public Autoridad(String id, String nombre, String tipo, String rol) {
        super(id, nombre, tipo);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método del diagrama
    public void gestionarIncidentes() {
        // TODO: Implementar lógica para gestionar incidentes
    }
}
