package src;
import java.util.Stack;

// Clase que gestiona el historial de cambios usando una pila
public class HistorialCambios {
    private Stack<CambioNota> historial;

    // Constructor
    public HistorialCambios() {
        this.historial = new Stack<>();
    }

    // Método para agregar un nuevo cambio al historial
    public void agregarCambio(int estudianteId, int materiaId, double notaAnterior, double notaNueva) {
        CambioNota cambio = new CambioNota(estudianteId, materiaId, notaAnterior, notaNueva);
        historial.push(cambio);
        System.out.println("Cambio agregado: " + cambio);
    }

    // Método para deshacer el último cambio
    public CambioNota deshacerUltimoCambio() {
        if (historial.isEmpty()) {
            System.out.println("No hay cambios para deshacer.");
            return null;
        }
        CambioNota ultimoCambio = historial.pop();
        System.out.println("Cambio deshecho: " + ultimoCambio);
        // Aquí podrías agregar lógica para revertir la nota en el sistema (ej. actualizar una base de datos)
        // Por ejemplo: sistemaDeNotas.revertirNota(ultimoCambio.getEstudianteId(), ultimoCambio.getMateriaId(), ultimoCambio.getNotaAnterior());
        return ultimoCambio;
    }

    // Método para ver el historial completo (sin modificar la pila)
    public void verHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println("Historial de cambios:");
        for (CambioNota cambio : historial) {
            System.out.println(cambio);
        }
    }

    // Método para verificar si el historial está vacío
    public boolean estaVacio() {
        return historial.isEmpty();
    }
}