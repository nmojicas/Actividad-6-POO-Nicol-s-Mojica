package ventanacontacto;
import java.time.LocalDate;

public class Contacto {
String nombres;
String apellidos;
LocalDate fechaNacimiento;
String dirección;
String teléfono;
String correo;

Contacto(String nombres, String apellidos, LocalDate
fechaNacimiento, String dirección, String teléfono, String correo)
{
this.nombres = nombres;
this.apellidos = apellidos;
this.fechaNacimiento = fechaNacimiento;
this.dirección = dirección;
this.teléfono = teléfono;
this.correo = correo;
}
}