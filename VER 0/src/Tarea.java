package src;
import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private String materia;
    private LocalDate fechaLimite;
    private int prioridad;  // Ej. 1 = baja, 5 = alta

    // Constructor
    public Tarea(String descripcion, String materia, LocalDate fechaLimite, int prioridad) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        if (materia == null || materia.trim().isEmpty()) {
            throw new IllegalArgumentException("La materia no puede estar vacía.");
        }
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5.");
        }
        this.descripcion = descripcion;
        this.materia = materia;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
    }

    // Getters
    public String getDescripcion() { return descripcion; }
    public String getMateria() { return materia; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public int getPrioridad() { return prioridad; }

    // Setters (opcionales, para modificar tareas si es necesario)
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setMateria(String materia) { this.materia = materia; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }

    // Método para representar la tarea como string
    @Override
    public String toString() {
        return String.format("Tarea{descripcion='%s', materia='%s', fechaLimite=%s, prioridad=%d}",
                descripcion, materia, fechaLimite, prioridad);
    }
} 
    
