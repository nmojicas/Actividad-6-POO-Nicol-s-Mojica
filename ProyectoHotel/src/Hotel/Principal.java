package Hotel;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Hotel hotel = new Hotel();
                VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal(hotel);
                miVentanaPrincipal.setVisible(true);
            }
        });
    }
}