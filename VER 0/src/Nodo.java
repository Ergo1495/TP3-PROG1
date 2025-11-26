package src;
public class Nodo {
    public Object dato;  // El dato almacenado (e.g., Materia, MiembroUniversidad)
    public Nodo siguiente;  // Referencia al siguiente nodo

    // Constructor
    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}