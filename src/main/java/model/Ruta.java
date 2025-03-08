package model;



public class Ruta {
    private String id;
    private double distancia;     // en kilómetros
    private int tiempoEstimado;   // en minutos
    private String inicio;
    private String fin;

    public Ruta(String id, double distancia, int tiempoEstimado, String inicio, String fin) {
        this.id = id;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters y setters...
    public String getId() { return id; }
    public double getDistancia() { return distancia; }
    public int getTiempoEstimado() { return tiempoEstimado; }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }

    public void setDistancia(double distancia) { this.distancia = distancia; }
    public void setTiempoEstimado(int tiempoEstimado) { this.tiempoEstimado = tiempoEstimado; }

    // Métodos del diagrama
    public void registrarRuta() {
        // TODO: Implementar registro de ruta
    }

    public void consultarRuta() {
        // TODO: Implementar consulta de ruta
    }

    public void generarRuta() {
        // TODO: Implementar generación de una nueva ruta (según la lógica)
    }

    public void generarReporteRuta() {
        // TODO: Implementar reporte de rutas
    }
}

