package src;
import java.time.LocalDateTime;

// Clase que representa un cambio en la nota de un estudiante
public class CambioNota {
    private int estudianteId;
    private int materiaId;
    private double notaAnterior;
    private double notaNueva;
    private LocalDateTime fecha;

    // Constructor
    public CambioNota(int estudianteId, int materiaId, double notaAnterior, double notaNueva) {
        if (notaAnterior < 0 || notaAnterior > 10 || notaNueva < 0 || notaNueva > 10) {
            throw new IllegalArgumentException("Las notas deben estar entre 0 y 10.");
        }
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
        this.notaAnterior = notaAnterior;
        this.notaNueva = notaNueva;
        this.fecha = LocalDateTime.now(); // Fecha automática al crear el cambio
    }

    // Getters
    public int getEstudianteId() { return estudianteId; }
    public int getMateriaId() { return materiaId; }
    public double getNotaAnterior() { return notaAnterior; }
    public double getNotaNueva() { return notaNueva; }
    public LocalDateTime getFecha() { return fecha; }

    // Método para representar el cambio como string (útil para depuración)
    @Override
    public String toString() {
        return String.format("CambioNota{estudianteId=%d, materiaId=%d, notaAnterior=%.2f, notaNueva=%.2f, fecha=%s}",
                estudianteId, materiaId, notaAnterior, notaNueva, fecha);
    }
}