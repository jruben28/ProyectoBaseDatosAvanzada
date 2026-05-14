/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneles;

import dtos.comunes.InquilinoDTO;
import dtos.salida.InmuebleSalidaDTO;
import excepcion.NegocioException;
import framePrincipal.FramePrincipal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import objetosNegocio.IInmuebleBO;
import objetosNegocio.InmuebleBO;

/**
 *
 * @author joser
 */
public class PantallaRegistrarInquilino extends javax.swing.JPanel {

    private FramePrincipal frame;
    private static IInmuebleBO inmuebleBO;
    private InmuebleSalidaDTO inmuebleSeleccionado;
    public JTextField txtNombre, txtApellidoP, txtApellidoM, txtIngreso, txtTelefono;
    public JButton btnAceptar, btnCancelar;
    
    /**
     * Creates new form PantallaRegistrarInquilino
     * @param frame
     */
    public PantallaRegistrarInquilino(FramePrincipal frame) {
        this.frame = frame;
        inmuebleBO = new InmuebleBO();
        setLayout(null);
        setBackground(new Color(211, 211, 211));
        iniciarComponentes();
    }

    public void recibirDTO(InmuebleSalidaDTO inmueble){
        this.inmuebleSeleccionado = inmueble;

    }
    
    public void iniciarComponentes(){
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 26);
        Font fuenteLabels = new Font("Arial", Font.PLAIN, 22);
        Font fuenteCampos = new Font("Arial", Font.PLAIN, 18);
        Color colorBoton = new Color(140, 140, 140);


        JLabel lblTitulo = new JLabel("Registro Arrendatario");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setBounds(60, 40, 400, 40);
        add(lblTitulo);


        JLabel lblNombre = new JLabel("Nombre(s):");
        lblNombre.setFont(fuenteLabels);
        lblNombre.setBounds(40, 110, 200, 30);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(40, 150, 300, 45);
        txtNombre.setFont(fuenteCampos);
        add(txtNombre);

        JLabel lblApellidoP = new JLabel("Apellido Paterno:");
        lblApellidoP.setFont(fuenteLabels);
        lblApellidoP.setBounds(370, 110, 250, 30);
        add(lblApellidoP);

        txtApellidoP = new JTextField();
        txtApellidoP.setBounds(370, 150, 300, 45);
        txtApellidoP.setFont(fuenteCampos);
        add(txtApellidoP);

        JLabel lblApellidoM = new JLabel("Apellido Materno:");
        lblApellidoM.setFont(fuenteLabels);
        lblApellidoM.setBounds(700, 110, 250, 30);
        add(lblApellidoM);

        txtApellidoM = new JTextField();
        txtApellidoM.setBounds(700, 150, 300, 45);
        txtApellidoM.setFont(fuenteCampos);
        add(txtApellidoM);


        JLabel lblIngreso = new JLabel("Ingreso Mensual:");
        lblIngreso.setFont(fuenteLabels);
        lblIngreso.setBounds(40, 240, 250, 30);
        add(lblIngreso);

        txtIngreso = new JTextField();
        txtIngreso.setBounds(40, 280, 250, 45);
        txtIngreso.setFont(fuenteCampos);
        add(txtIngreso);

        JLabel lblTelefono = new JLabel("Número de teléfono:");
        lblTelefono.setFont(fuenteLabels);
        lblTelefono.setBounds(330, 240, 300, 30);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(330, 280, 300, 45);
        txtTelefono.setFont(fuenteCampos);
        add(txtTelefono);

        btnCancelar = new JButton("Cancelar operación");
        btnCancelar.setBounds(100, 500, 350, 65);
        btnCancelar.setFont(fuenteLabels);
        btnCancelar.setBackground(colorBoton);
        btnCancelar.setFocusable(false);
        add(btnCancelar);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(750, 500, 350, 65);
        btnAceptar.setFont(fuenteLabels);
        btnAceptar.setBackground(colorBoton);
        btnAceptar.setFocusable(false);
        add(btnAceptar);


        btnCancelar.addActionListener(e -> {
            limpiarCampos();
            frame.mostrarPanel("PanelGestorArrendamiento");
            
        });

        btnAceptar.addActionListener(e -> {
            InquilinoDTO inquilino = new InquilinoDTO(txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText(), Float.parseFloat(txtIngreso.getText()), txtTelefono.getText());
            try{
                inmuebleBO.registrarInquilino(inmuebleSeleccionado.idInmueble(), inquilino);
            }
            catch(NegocioException ex){
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Registro exitoso para la propiedad en: " + inmuebleSeleccionado.direccion());
            this.inmuebleSeleccionado = null;
            frame.cambiarPantalla("PanelGestorArrendamiento");
            limpiarCampos();
        });
    };
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtIngreso.setText("");
        txtTelefono.setText("");
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
