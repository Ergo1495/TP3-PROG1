package src;
public class Materia {
 private String nombre;
 private Profesor profesor;
 private double nota;

 public Materia(String nombre){
   this.nombre=nombre; 
 }

 public Materia(String nombre,Profesor profesor){
   this.nombre=nombre;
   this.profesor=profesor;
 }

 public String getNombre(){
    return nombre;
 }

 public void setNombre(String nombre){
    this.nombre=nombre;
 }

 public Profesor getProfesor(){
    return profesor;
 }

 public void setProfesor(Profesor profesor) {
    this.profesor = profesor;
}
public double getNota() {
    return nota;
}
public void setNota(double nota) {
    this.nota = nota;
}

@Override
public String toString() {
    return "Materia {\n" +
           "  Nombre: " + nombre + "\n" +
           "  Profesor: " + 
              (profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "Sin asignar") +
           "\n}";
}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Materia materia = (Materia) obj;
    return nombre != null ? nombre.equals(materia.nombre) : materia.nombre == null;
}
@Override
public int hashCode() {
    return nombre != null ? nombre.hashCode() : 0;
 }    
}
