package Nómina;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class VentanaNómina extends JFrame {
    private Container contenedor; 
    private ListaEmpleados lista; 
    private JLabel empleados, nómina; 
    private JTable tabla; 
    private JScrollPane scrollTabla; 

    public VentanaNómina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina de Empleados"); 
        setSize(350,250); 
        setLocationRelativeTo(null); 
        setResizable(false); 
    }

    public void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 
        empleados = new JLabel();
        empleados.setText("Lista de empleados:");
        empleados.setBounds(20, 10, 135, 23);
        String[][] datos = lista.obtenerMatriz(); 
        String[] titulos = { "NOMBRE","APELLIDOS","SUELDO"};

        DefaultTableModel model = new
        DefaultTableModel(datos,titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(model); 
        scrollTabla = new JScrollPane(tabla); 
        scrollTabla.setBounds(20, 35, 310, 120); 
        
        nómina = new JLabel();
        nómina.setText("Total nómina mensual = $ " + String.
        format("%.2f", lista.totalNómina));
        nómina.setBounds(20, 165, 250, 23);
        
        contenedor.add(empleados);
        contenedor.add(scrollTabla); 
        contenedor.add(nómina);
    }
}