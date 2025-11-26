package src;
public class Personal extends Persona implements MiembroUniversidad {
    private String departamento;
    private String puesto;
    private String fechaIngreso;

    public Personal(String nombre, String apellido, String documento, int edad, String departamento, String puesto, String fechaIngreso) {
        super(nombre, apellido, documento, edad);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String obtenerRol() {
        return "Personal";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
        return "Personal {\n" +
               "  Nombre: " + getNombre() + " " + getApellido() + "\n" +
               "  Documento: " + getDocumento() + "\n" +
               "  Edad: " + getEdad() + "\n" +
               "  Departamento: " + departamento + "\n" +
               "  Puesto: " + puesto + "\n" +
               "  Fecha de ingreso: " + fechaIngreso + "\n" +
               "}";
    }
}