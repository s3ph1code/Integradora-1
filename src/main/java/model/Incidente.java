package model;


public class Incidente {
    private String id;
    private String tipo;       // robo, accidente, incendio, etc.
    private String ubicacion;  // dirección o coordenadas
    private String fechaHora;
    private String descripcion;
    private String estado;     // pendiente, en proceso, resuelto

    public Incidente(String id, String tipo, String ubicacion, String fechaHora,
                     String descripcion, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Getters y setters...
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public String getUbicacion() { return ubicacion; }
    public String getFechaHora() { return fechaHora; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void registrarIncid() {
        // TODO: Implementar registro de incidente
    }

    public void actualizarEstado(String nuevoEstado) {
        // TODO: Implementar actualización de estado
        this.estado = nuevoEstado;
    }

    public void generarReporteIncidentes() {
        // TODO: Implementar generación de reporte de incidentes
    }

    public void gestionarIncidentes(){

    }
}

