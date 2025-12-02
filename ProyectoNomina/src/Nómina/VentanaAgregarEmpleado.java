package Nómina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarEmpleado extends JFrame implements
ActionListener {
    private Container contenedor; 
    private ListaEmpleados lista; 
    private JLabel nombre, apellidos, cargo, salarioDía, númeroDías,
    género, otrosIngresos, aportesSalud, pensiones;
    private JTextField campoNombre, campoApellidos,
    campoSalarioDía, campoOtrosIngresos, campoAportesSalud,
    campoPensiones;

    private ButtonGroup grupoGénero; 
    private JRadioButton masculino, femenino; 
    private JComboBox campoCargo; 
    private JSpinner campoNúmeroDías; 
    private SpinnerNumberModel modeloSpinner; 
    private JButton agregar, limpiar;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Agregar Empleado"); 
        setSize(300,400); 
        setLocationRelativeTo(null); 
        setResizable(false); 
    }

    public void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 
        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(160, 20, 100, 23);

        apellidos = new JLabel();
        apellidos.setText("Apellidos:");
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(160, 50, 100, 23);

        cargo = new JLabel();
        cargo.setText("Cargo:");
        cargo.setBounds(20, 80, 135, 23); 
        campoCargo = new JComboBox();
        campoCargo.addItem("Directivo");
        campoCargo.addItem("Estratégico");
        campoCargo.addItem("Operativo");
        campoCargo.setBounds(160, 80, 100, 23);

        género = new JLabel();
        género.setText("Género:");
        género.setBounds(20,110,100,30);
        grupoGénero = new ButtonGroup(); 
        masculino = new JRadioButton("Masculino", true);
        masculino.setBounds(160,110,100,30); 
        grupoGénero.add(masculino); 
        femenino = new JRadioButton("Femenino");
        femenino.setBounds(160,140,100,30); 
        grupoGénero.add(femenino); 

        salarioDía = new JLabel();
        salarioDía.setText("Salario por día:");
        salarioDía.setBounds(20, 170, 135, 23);
        campoSalarioDía = new JTextField();
        campoSalarioDía.setBounds(160, 170,100, 23);

        númeroDías = new JLabel();
        númeroDías.setText("Días trabajados al mes:");
        númeroDías.setBounds(20, 200, 135, 23);
        campoNúmeroDías = new JSpinner(); 
        modeloSpinner = new SpinnerNumberModel(); 
        modeloSpinner.setMinimum(1);
        modeloSpinner.setMaximum(31);
        modeloSpinner.setValue(30);
        campoNúmeroDías.setModel(modeloSpinner); 
        campoNúmeroDías.setBounds(160, 200, 40, 23); 

        otrosIngresos = new JLabel();
        otrosIngresos.setText("Otros ingresos:");
        otrosIngresos.setBounds(20, 230, 135, 23);
        campoOtrosIngresos = new JTextField();
        campoOtrosIngresos.setBounds(160, 230, 100, 23);

        aportesSalud = new JLabel();
        aportesSalud.setText("Pagos por salud:");
        aportesSalud.setBounds(20, 260, 135, 23);
        campoAportesSalud = new JTextField();
        campoAportesSalud.setBounds(160, 260, 100, 23);

        pensiones = new JLabel();
        pensiones.setText("Aportes pensiones:");
        pensiones.setBounds(20, 290, 135, 23);
        campoPensiones = new JTextField();
        campoPensiones.setBounds(160, 290, 100, 23);

        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(20, 320, 100, 23); 
        agregar.addActionListener(this);

        limpiar = new JButton();
        limpiar.setText("Borrar");
        limpiar.setBounds(160, 320, 80, 23); 
        limpiar.addActionListener(this);

        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(cargo);
        contenedor.add(campoCargo);
        contenedor.add(género);
        contenedor.add(masculino);
        contenedor.add(femenino);
        contenedor.add(salarioDía);
        contenedor.add(campoSalarioDía);
        contenedor.add(númeroDías);
        contenedor.add(campoNúmeroDías);
        contenedor.add(otrosIngresos);
        contenedor.add(campoOtrosIngresos);
        contenedor.add(aportesSalud);
        contenedor.add(campoAportesSalud);
        contenedor.add(pensiones);
        contenedor.add(campoPensiones);
        contenedor.add(agregar);
        contenedor.add(limpiar);
    }

    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoSalarioDía.setText("");
        campoNúmeroDías.setValue(30);
        campoOtrosIngresos.setText("");
        campoAportesSalud.setText("");
        campoPensiones.setText("");
        masculino.setSelected(true);
        campoCargo.setSelectedIndex(0);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == agregar) { 
            añadirEmpleado();
        }
        if (evento.getSource() == limpiar) { 
            limpiarCampos();
        }
    }

    private void añadirEmpleado() {
        TipoCargo tipoC;
        String itemSeleccionado = (String) campoCargo.
        getSelectedItem();
        
        if (itemSeleccionado.equals("Directivo")) {
            tipoC = TipoCargo.DIRECTIVO;
        } else if (itemSeleccionado.equals("Estratégico")) {
            tipoC = TipoCargo.ESTRATÉGICO;
        } else {
            tipoC = TipoCargo.OPERATIVO;
        }
        TipoGénero tipoG;
        
        if (masculino.isSelected()) {
            tipoG = TipoGénero.MASCULINO;
        } else {
            tipoG = TipoGénero.FEMENINO;
        }
        try {
            String valor1 = campoNombre.getText(); 
            String valor2 = campoApellidos.getText(); 
            
            if (valor1.trim().isEmpty() || valor2.trim().isEmpty() || 
                campoSalarioDía.getText().trim().isEmpty() ||
                campoOtrosIngresos.getText().trim().isEmpty() ||
                campoAportesSalud.getText().trim().isEmpty() ||
                campoPensiones.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Ningún campo de texto debe estar vacío.");
            }
            
            double valor3 = Double.parseDouble(campoSalarioDía.
            getText());
            int valor4 = (int) campoNúmeroDías.getValue();
            double valor5 = Double.parseDouble(campoOtrosIngresos.
            getText());
            double valor6 = Double.parseDouble(campoAportesSalud.
            getText());
            double valor7 = Double.parseDouble(campoPensiones.
            getText());
            
            if (valor3 < 0 || valor4 < 1 || valor4 > 31 || valor5 < 0 || valor6 < 0 || valor7 < 0) {
                 throw new IllegalArgumentException("Los valores numéricos deben ser válidos (Salario > 0, Días trabajados entre 1 y 31, Otros ingresos/Pagos/Aportes >= 0).");
            }
            
            Empleado e = new Empleado(valor1, valor2, tipoC, tipoG,
            valor3, valor4, valor5, valor6, valor7); 
            lista.agregarEmpleado(e); 
            JOptionPane.showMessageDialog(this,"El empleado ha sido" +
            " agregado","Mensaje", JOptionPane.INFORMATION_MESSAGE,null);
            limpiarCampos();
        } catch (NumberFormatException e) { 
            JOptionPane.showMessageDialog(null,"Error en el formato de un número. Asegúrese de ingresar solo números en los campos correspondientes.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) { 
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Ocurrió un error al agregar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}