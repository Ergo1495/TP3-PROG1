package src;
import java.time.LocalTime;
public class TurnoConsulta {
 private String estudiante;
 private String motivo;
 private LocalTime horaLlegada;
 private int duracionEstimada;   

public TurnoConsulta(String estudiante,String motivo,LocalTime horaLlegada,int duracionEstimada){
   if (estudiante==null||estudiante.trim().isEmpty()){
    throw new IllegalArgumentException("El estudiante no puede estar vacio");
   }
  if (duracionEstimada<=0){
   throw new IllegalArgumentException("la duracion estimada debe ser positiva");
  }
  this.estudiante=estudiante;
  this.motivo=motivo;
  this.horaLlegada=horaLlegada;
  this.duracionEstimada=duracionEstimada;
}

//Getters
public String getEstudiante(){return estudiante;}
public String getMotivo (){return motivo;}
public LocalTime getHoraLlegada(){return horaLlegada;}
public int getDuracionEstimada(){return duracionEstimada;}

 // Setters (opcionales, para modificar turnos si es necesario)
 public void setEstudiante(String estudiante) { this.estudiante = estudiante; }
 public void setMotivo(String motivo) { this.motivo = motivo; }
 public void setHoraLlegada(LocalTime horaLlegada) { this.horaLlegada = horaLlegada; }
 public void setDuracionEstimada(int duracionEstimada) { this.duracionEstimada = duracionEstimada; }
 // Método para representar el turno como string
 @Override
 public String toString() {
     return String.format("TurnoConsulta{estudiante='%s', motivo='%s', horaLlegada=%s, duracionEstimada=%d min}",
             estudiante, motivo, horaLlegada, duracionEstimada);
 }
}















