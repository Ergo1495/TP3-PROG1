package src;
import java.util.Arrays;
import java.util.Stack;
import java.time.LocalDate;

public class Estudiante extends Persona implements MiembroUniversidad {
    private String carrera;
    private double promedio;
    private ListaEnlazada materias;
    private Stack<Tarea> tareasPendientes;  // Nuevo atributo: Pila para tareas pendientes

    public Estudiante(String nombre, String apellido, String documento, int edad, String carrera, double promedio, ListaEnlazada materias) {
        super(nombre, apellido, documento, edad);
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = materias;
        this.tareasPendientes = new Stack<>();  // Inicializar la pila
    }

    // Getters y setters existentes
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public double getPromedio() { return promedio; }
    public ListaEnlazada getMaterias() { return materias; }
    public void setMaterias(ListaEnlazada materias) { this.materias = materias; }

    // Nuevo getter para tareas pendientes
    public Stack<Tarea> getTareasPendientes() { return tareasPendientes; }

    // Método para agregar una tarea a la pila (última agregada es la primera en procesarse)
    public void agregarTarea(String descripcion, String materia, LocalDate fechaLimite, int prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, materia, fechaLimite, prioridad);
        tareasPendientes.push(nuevaTarea);
        System.out.println("Tarea agregada: " + nuevaTarea);
    }

    // Método para completar la última tarea (saca de la pila)
    public Tarea completarUltimaTarea() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("No hay tareas pendientes para completar.");
            return null;
        }
        Tarea tareaCompletada = tareasPendientes.pop();
        System.out.println("Tarea completada: " + tareaCompletada);
        return tareaCompletada;
    }

    // Método para ver la próxima tarea (sin sacarla de la pila)
    public void verProximaTarea() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        Tarea proxima = tareasPendientes.peek();
        System.out.println("Próxima tarea: " + proxima);
    }

    // Método existente para calcular promedio recursivo
    public double calcularPromedioRecursivo() {
        return calcularPromedioRecursivo(materias.primero, 0, 0.0);
    }

    private static double calcularPromedioRecursivo(Nodo actual, int contador, double suma) {
        if (actual == null) {
            return contador == 0 ? 0 : suma / contador;
        }
        Materia materia = (Materia) actual.dato;
        return calcularPromedioRecursivo(actual.siguiente, contador + 1, suma + materia.getNota());
    }

    @Override
    public String obtenerRol() { return "Estudiante"; }

    @Override
    public String obtenerInformacionCompleta() { return toString(); }

    @Override
    public String toString() {
        String nombresMaterias = Arrays.stream(materias.convertirAArray())
                                       .map(obj -> ((Materia) obj).getNombre())
                                       .reduce((a, b) -> a + ", " + b)
                                       .orElse("Sin materias");

        return "Estudiante {\n" +
               "  Nombre: " + getNombre() + " " + getApellido() + "\n" +
               "  Documento: " + getDocumento() + "\n" +
               "  Edad: " + getEdad() + "\n" +
               "  Carrera: " + carrera + "\n" +
               "  Promedio: " + promedio + "\n" +
               "  Materias: [" + nombresMaterias + "]\n" +
               "  Tareas Pendientes: " + tareasPendientes.size() + " tareas\n" +  // Agregado para mostrar cantidad
               "}";
    }
}