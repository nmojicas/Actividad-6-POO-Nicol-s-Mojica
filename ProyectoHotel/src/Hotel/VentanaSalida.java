package Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class VentanaSalida extends JFrame implements ActionListener {
    private Hotel hotel;
    private int númeroHabitación;
    private JTextField campoFechaSalida;
    
    public VentanaSalida(Hotel hotel, int númeroHabitación) {
        this.hotel = hotel;
        this.númeroHabitación = númeroHabitación;
        setTitle("Salida Huésped Hab: " + númeroHabitación);
        setSize(300, 200);
        setLocationRelativeTo(null);
        campoFechaSalida = new JTextField();
        JButton botónSalida = new JButton("Confirmar Salida");
        botónSalida.addActionListener(this);
        
        setLayout(new java.awt.FlowLayout());
        add(new JLabel("Fecha Salida (yyyy-MM-dd):"));
        add(campoFechaSalida);
        add(botónSalida);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Huésped huésped = Hotel.listaHabitaciones.elementAt(númeroHabitación - 1).getHuésped();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaSalida = formatoFecha.parse(campoFechaSalida.getText());
            huésped.setFechaSalida(fechaSalida);
            
            int días = huésped.obtenerDíasAlojamiento();
            double precio = Hotel.listaHabitaciones.elementAt(númeroHabitación - 1).getPrecioDía();
            double total = días * precio;
            
            JOptionPane.showMessageDialog(this, "Salida confirmada. Días: " + días + ", Total a pagar: $" + String.format("%.2f", total), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        
            Hotel.listaHabitaciones.elementAt(númeroHabitación - 1).setDisponible(true);
            Hotel.listaHabitaciones.elementAt(númeroHabitación - 1).setHuésped(null);

            dispose();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Error en la salida o formato de fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}