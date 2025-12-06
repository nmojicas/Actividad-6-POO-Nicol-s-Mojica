package ventanacontacto;
import java.util.Vector;

public class ListaContactos {
Vector lista;

ListaContactos() {
lista = new Vector();
}

void agregarContacto(Contacto contacto) {
lista.add(contacto);
}
}