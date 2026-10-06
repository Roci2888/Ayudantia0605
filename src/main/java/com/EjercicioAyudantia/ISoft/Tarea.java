package com.EjercicioAyudantia.ISoft;

public class Tarea {

    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada;

    public Tarea() {
        this.completada = false;
    }

    public Tarea(Long id, String titulo, String prioridad, String fechaLimite) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.completada = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(String fechaLimite) { this.fechaLimite = fechaLimite; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
}
