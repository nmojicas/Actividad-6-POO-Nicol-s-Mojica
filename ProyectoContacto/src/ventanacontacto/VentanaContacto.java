package ventanacontacto;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class VentanaContacto extends Application {
Label nombres = new Label("Nombres:");
Label apellidos = new Label("Apellidos:");
Label fechaNacimiento = new Label("Fecha nacimiento:");
Label dirección = new Label("Dirección");
Label correo = new Label("Correo");
Label teléfono = new Label("Teléfono");
TextField campoNombres = new TextField();
TextField campoApellidos = new TextField();
DatePicker campoFechaNacimiento = new DatePicker();
TextField campoDirección = new TextField();
TextField campoCorreo = new TextField();
TextField campoTeléfono = new TextField();
ListView lista = new ListView();
Button agregar = new Button("Agregar");

public static void main(String[] args) {
Application.launch(args);
}

@Override
public void start(Stage stage) throws Exception {
GridPane grid = new GridPane();
grid.setHgap(5);
grid.setVgap(5);
grid.add(nombres, 0, 0);
grid.add(apellidos, 0, 1);
grid.add(fechaNacimiento, 0, 2);
grid.add(dirección, 0, 3);
grid.add(teléfono, 0, 4);
grid.add(correo, 0, 5);
grid.add(campoNombres, 1, 0);
grid.add(campoApellidos, 1, 1);
grid.add(campoFechaNacimiento, 1, 2);
grid.add(campoDirección, 1, 3);
grid.add(campoTeléfono, 1, 4);
grid.add(campoCorreo, 1, 5);
grid.add(lista, 2, 0, 1, 7);
VBox buttonBox = new VBox(agregar);
agregar.setMaxWidth(Double.MAX_VALUE);
grid.add(buttonBox, 0, 6, 1, 2);
agregar.setOnAction(e -> mostrarDatos());
grid.setStyle("-fx-padding: 10;"
+ "-fx-border-style: solid inside;"
+ "-fx-border-width: 2;"
+ "-fx-border-insets: 5;"
+ "-fx-border-radius: 5;"
+ "-fx-border-color: green;");
Scene scene = new Scene(grid, 600, 300);
stage.setScene(scene);
stage.setTitle("Detalles del contacto");
stage.sizeToScene();
stage.show();
}

private void mostrarDatos() {
String a = campoNombres.getText();
String b = campoApellidos.getText();
LocalDate c = campoFechaNacimiento.getValue();
String d = campoDirección.getText();
String e = campoTeléfono.getText();
String f = campoCorreo.getText();
if (a.equals("") || b.equals("") || d.equals("") ||
e.equals("") || f.equals("")) {
Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
mensaje.setTitle("Mensaje");
mensaje.setHeaderText("Error en ingreso de datos");
mensaje.setContentText("No se permiten campos vacíos");
mensaje.showAndWait();
} else {
Contacto contacto = new Contacto(a,b,c,d,e,f);
ListaContactos listaContactos = new ListaContactos();
listaContactos.agregarContacto(contacto);
String data = a + "-" + b + "-" + c + "-" + d + "-" + e + "-" + f;
lista.getItems().add(data);
campoNombres.setText("");
campoApellidos.setText("");
campoFechaNacimiento.setValue(null);
campoDirección.setText("");
campoTeléfono.setText("");
campoCorreo.setText("");
}
}
}