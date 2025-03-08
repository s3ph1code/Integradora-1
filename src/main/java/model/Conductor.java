package model;



public class Conductor extends Usuario {
    private String vehiculo;
    private String estado;

    public Conductor(String id, String nombre, String tipo, String vehiculo, String estado) {
        super(id, nombre, tipo);
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos del diagrama
    public void registrarConduc() {
        // TODO: Implementar lógica de registro de conductor
    }

    public Conductor buscarConduc(String idBuscado) {
        // TODO: Implementar lógica para buscar un conductor
        return null;
    }

    public void generarReporteConduc() {
        // TODO: Implementar generación de reporte para conductor
    }
}

