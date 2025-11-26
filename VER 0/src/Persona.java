package src;
public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private int edad;

    public Persona(String nombre, String apellido, String documento, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona {\n" +
               "  Nombre: " + nombre + " " + apellido + "\n" +
               "  Documento: " + documento + "\n" +
               "  Edad: " + edad + "\n" +
               "}";
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return documento != null ? documento.equals(persona.documento) : persona.documento == null;
    }

    @Override
    public int hashCode() {
        return documento != null ? documento.hashCode() : 0;
    }
}