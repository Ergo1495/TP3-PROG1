package src;
import java.lang.classfile.attribute.MethodParametersAttribute;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
 public static void main (String[]args){
   Materia matematicas = new Materia ("Matematicas");
   Materia fisica = new Materia ("Fisica");
//Estudiante
   ListaEnlazada materiasEstudiante=new ListaEnlazada ();
   materiasEstudiante.agregar(matematicas);
   Estudiante estudiante=new Estudiante ("Juan", "Pérez", "12345678", 20, "Ingeniería", 8.5, materiasEstudiante);

//Profesor   
   ListaEnlazada materiasProfesor=new ListaEnlazada();
   materiasProfesor.agregar(matematicas);
   Profesor profesor = new Profesor("Ana", "Gómez", "87654321", 45, "Matemáticas", 15, materiasProfesor);
//Personal
   Personal personal = new Personal ("Carlos", "López", "11223344", 30, "Administración", "Secretario", "2020-01-15");

//universidad
Universidad universidad=new Universidad();
universidad.agregarMiembro(estudiante);
universidad.agregarMiembro(profesor);
universidad.agregarMiembro(personal);
System.out.println("===Procesando todos los miembros===");
Nodo actual=universidad.getMiembros().primero;
while(actual !=null){
  MiembroUniversidad miembro = (MiembroUniversidad) actual.dato;
  System.out.println("rol:"+ miembro.obtenerRol());
  System.out.println("Informacion:"+miembro.obtenerInformacionCompleta());
  System.out.println("---");
  actual=actual.siguiente;
}

universidad.listarTodos();
        System.out.println("\n=== Buscando profesores ===");
        ListaEnlazada profesores = universidad.buscarPorRol("Profesor");  // Ahora devuelve ListaEnlazada
        Nodo actualProf = profesores.primero;
        while (actualProf != null) {
            MiembroUniversidad p = (MiembroUniversidad) actualProf.dato;
            System.out.println(p.obtenerInformacionCompleta());
            actualProf = actualProf.siguiente;
        }
        universidad.mostrarRoles();
        
        Estudiante e1 = new Estudiante("Juan", "Zuluaga", "123", 20, "Ingeniería", 8.5, new ListaEnlazada());  // Cambiado a ListaEnlazada
        Estudiante e2 = new Estudiante("Ana", "Pérez", "456", 22, "Medicina", 9.0, new ListaEnlazada());  // Cambiado a ListaEnlazada
        Estudiante e3 = new Estudiante("Carlos", "Gómez", "789", 21, "Derecho", 7.5, new ListaEnlazada());  // Cambiado a ListaEnlazada
        universidad.agregarMiembro(e1);
        universidad.agregarMiembro(e2);
        universidad.agregarMiembro(e3);

        System.out.println("\n=== Estudiantes ordenados por apellido ===");
        ListaEnlazada ordenados = universidad.ordenarEstudiantesPorApellido();  // Ahora devuelve ListaEnlazada
        Nodo actualOrd = ordenados.primero;
        while (actualOrd != null) {
            Estudiante e = (Estudiante) actualOrd.dato;
            System.out.println(e.getApellido() + ", " + e.getNombre());
            actualOrd = actualOrd.siguiente;
        }
    
    System.out.println("\n=== Sistema de Historial de Cambios ===");
    HistorialCambios historial = new HistorialCambios();
    
    int idMatematicas = 101; 
    int idFisica = 102;       
   
    int idEstudianteJuan = 1; 
    historial.agregarCambio(idEstudianteJuan, idMatematicas, 8.5, 9.0);  // Nota anterior 8.5, nueva 9.0
    int idEstudianteAna = 2;  // ID ficticio para Ana
    historial.agregarCambio(idEstudianteAna, idFisica, 7.0, 8.5);  // Nota anterior 7.0, nueva 8.5

// === Integración del Sistema de Tareas Pendientes (usando Pila) ===
System.out.println("\n=== Sistema de Tareas Pendientes ===");
Estudiante estudianteConTareas = (Estudiante) universidad.buscarPorRol("Estudiante").primero.dato;  // Tomar el primer estudiante (Juan Pérez)

if (estudianteConTareas != null) {
    // Agregar tareas (última agregada tiene prioridad)
    estudianteConTareas.agregarTarea("Estudiar álgebra", "Matemáticas", LocalDate.of(2023, 10, 15), 5);
    estudianteConTareas.agregarTarea("Hacer laboratorio", "Física", LocalDate.of(2023, 10, 20), 4);
    estudianteConTareas.agregarTarea("Leer capítulo 5", "Historia", LocalDate.of(2023, 10, 18), 3);

    // Ver próxima tarea
    estudianteConTareas.verProximaTarea();

    // Completar la última tarea (la más reciente)
    estudianteConTareas.completarUltimaTarea();

    // Ver próxima tarea después de completar
    estudianteConTareas.verProximaTarea();

    // Completar otra
    estudianteConTareas.completarUltimaTarea();

   }
System.out.println("\n=== Sistema de Turnos para Consultas ===");
Profesor profesorConConsultas = (Profesor) universidad.buscarPorRol("Profesor").primero.dato;  // Tomar el primer profesor (Ana Gómez)
if (profesorConConsultas != null) {
    // Agregar turnos de estudiantes (en orden FIFO)
    profesorConConsultas.agregarEstudianteACola("Juan Pérez", "Duda en álgebra", LocalTime.of(9, 0), 30);
    profesorConConsultas.agregarEstudianteACola("Ana Pérez", "Ayuda con laboratorio", LocalTime.of(9, 15), 45);
    profesorConConsultas.agregarEstudianteACola("Carlos Gómez", "Revisar examen", LocalTime.of(9, 30), 20);
    // Ver siguiente en cola
    profesorConConsultas.verSiguienteEnCola();
    // Atender al siguiente estudiante
    profesorConConsultas.atenderSiguienteEstudiante();
    // Ver siguiente después de atender
    profesorConConsultas.verSiguienteEnCola();
    // Atender otro
    profesorConConsultas.atenderSiguienteEstudiante();
}   
}
}