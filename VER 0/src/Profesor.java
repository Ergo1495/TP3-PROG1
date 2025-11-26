package src;

import java.time.LocalTime;

public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int aniosExperiencia;
    private ListaEnlazada materiasAsignadas;

    // Cola para sistema de turnos
    private Cola colaTurnos = new Cola();

    public Profesor(String nombre, String apellido, String documento, int edad,
                    String especialidad, int aniosExperiencia, ListaEnlazada materiasAsignadas) {
        super(nombre, apellido, documento, edad);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.materiasAsignadas = materiasAsignadas;
    }

    // ======================= GETTERS / SETTERS ==========================
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public ListaEnlazada getMateriasAsignadas() { return materiasAsignadas; }
    public void setMateriasAsignadas(ListaEnlazada materiasAsignadas) { this.materiasAsignadas = materiasAsignadas; }

    public void asignarMateria(Materia materia) {
        if (materiasAsignadas != null && !materiasAsignadas.contiene(materia)) {
            materiasAsignadas.agregar(materia);
            materia.setProfesor(this);
        }
    }

    // ====================== SISTEMA DE TURNOS (COLA) =====================

    public void agregarEstudianteACola(String estudiante, String motivo, LocalTime hora, int duracion) {
        TurnoConsulta turno = new TurnoConsulta(estudiante, motivo, hora, duracion);
        colaTurnos.encolar(turno);
        System.out.println("Turno agregado: " + turno);
    }

    public void verSiguienteEnCola() {
        TurnoConsulta siguiente = (TurnoConsulta) colaTurnos.verPrimero();
        if (siguiente == null) {
            System.out.println("No hay estudiantes en la cola.");
        } else {
            System.out.println("Siguiente turno: " + siguiente);
        }
    }

    public void atenderSiguienteEstudiante() {
        TurnoConsulta atendido = (TurnoConsulta) colaTurnos.desencolar();
        if (atendido == null) {
            System.out.println("No hay estudiantes para atender.");
        } else {
            System.out.println("Atendiendo a: " + atendido);
        }
    }

    // ====================== INTERFAZ MIEMBRO ======================
    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
        return "Profesor {\n" +
               "  Nombre: " + getNombre() + " " + getApellido() + "\n" +
               "  Documento: " + getDocumento() + "\n" +
               "  Edad: " + getEdad() + "\n" +
               "  Especialidad: " + especialidad + "\n" +
               "  Años de experiencia: " + aniosExperiencia + "\n" +
               "}";
    }
}
