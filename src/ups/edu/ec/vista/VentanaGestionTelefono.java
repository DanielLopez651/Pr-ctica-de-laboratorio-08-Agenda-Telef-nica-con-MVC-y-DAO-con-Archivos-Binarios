/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import ups.edu.ec.controlador.ControladorTelefono;
import ups.edu.ec.controlador.ControladorUsuario;
import ups.edu.ec.modelo.Telefono;

/**
 *
 * @author user
 */
public class VentanaGestionTelefono extends javax.swing.JInternalFrame {

    private List<String> operadoras;
    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;

    /**
     * Creates new form VentanaGestionTelefono
     */
    public VentanaGestionTelefono(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        this.controladorUsuario = controladorUsuario;
        this.controladorTelefono = controladorTelefono;
        initComponents();

        cargarDatosOperadora();

    }

    public void cargarDatosOperadora() {
        operadoras = new ArrayList<>();
        operadoras.add("Movsitar");
        operadoras.add("Claro");
        operadoras.add("Etapa");
        cargarDatoscbxOperadora();
    }

    public void cargarDatoscbxOperadora() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cbxOperadora.getModel();

        for (String operadora : operadoras) {
            modelo.addElement(operadora);
        }
    }

    public void cargarTelefonosTblTelefonos() {
//        DefaultTableModel modelo =  (DefaultTableModel) tblTelefonos.getModel();
//        modelo.setRowCount(0);
//        for(Telefono telefono: controladorUsuario.listarTelefonos()){
//            Object[] rowData={telefono.getCodigo(),telefono.getTipo(),telefono.getNumero(),telefono.getOperadora()};
//           modelo.addRow(rowData);
//        }
//
//           tblTelefonos.setModel(modelo);
//     
//    }
        DefaultTableModel modelo = (DefaultTableModel) tblTelefonos.getModel();

        modelo.setRowCount(0);

        for (Telefono telefono : controladorUsuario.listarTelefonosUsuario()) {
            Object[] rowData = {telefono.getCodigo(), telefono.getNumero().trim(),
                telefono.getOperadora().trim(), telefono.getTipo().trim()};
            modelo.addRow(rowData);
        }
        tblTelefonos.setModel(modelo);
    }

    public void cargarSiguienteCodigo() {
        int cod = controladorUsuario.codigoTelefono();
        txtCodigo.setText(String.valueOf(cod));
    }

    public void activarEdicion() {
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void desactivarEdicion() {
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        txtNumero = new javax.swing.JFormattedTextField();
        cbxOperadora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 204));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setText("0");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione su tipo---", "Casa", "Movil", "Fax", "Localizador" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        try {
            txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cbxOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione una operadora---" }));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Numero:");

        jLabel4.setText("Operadora:");

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Numero", "Operadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTelefonos);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregar))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)))
                .addGap(32, 32, 32)
                .addComponent(btnCancelar)
                .addGap(442, 442, 442))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        try {
            String item = (String) cbxTipo.getSelectedItem();
            if (item.equals("Casa")) {
                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));
            } else if (item.equals("Movil")) {
                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-####")
                        ));
            }
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        controladorUsuario.agregarTelefono(Integer.parseInt(txtCodigo.getText()), txtNumero.getText(), cbxTipo.getSelectedItem().toString(), cbxOperadora.getSelectedItem().toString());
        cargarTelefonosTblTelefonos();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cargarSiguienteCodigo();
        cargarTelefonosTblTelefonos();
        desactivarEdicion();
    }//GEN-LAST:event_formInternalFrameActivated

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
//        int filaIndex=tblTelefonos.getSelectedRow();
//        if(filaIndex>=0){
//            activarEdicion();
//            btnAgregar.setEnabled(false);
//        int codigo=(int)tblTelefonos.getValueAt(filaIndex, 0);
//        String tipo=(String)tblTelefonos.getValueAt(filaIndex, 1);
//        String numero=(String)tblTelefonos.getValueAt(filaIndex, 2);
//        String operadora=(String)tblTelefonos.getValueAt(filaIndex, 3);
//        txtCodigo.setText(String.valueOf(codigo));
//        cbxTipo.setSelectedItem(tipo);
//        txtNumero.setValue(numero);
//        cbxOperadora.setSelectedItem(operadora);
//        }
        int fila = tblTelefonos.getSelectedRow();
        int codigo= (int) tblTelefonos.getValueAt(fila, 0);
        String numero = (String) tblTelefonos.getValueAt(fila, 1);
        String tipo = (String) tblTelefonos.getValueAt(fila, 2);
        String operadora = (String) tblTelefonos.getValueAt(fila, 3);

        txtCodigo.setText(String.valueOf(codigo));
        txtNumero.setValue(numero);
        cbxTipo.setSelectedItem(tipo);
        cbxOperadora.setSelectedItem(operadora);

        activarEdicion();

    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        String numero = txtNumero.getText();
        String operadora = cbxOperadora.getSelectedItem().toString();
        String tipo = cbxTipo.getSelectedItem().toString();
        int codigo = Integer.parseInt(txtCodigo.getText());

        if (numero.isEmpty()
                || tipo.equals(cbxTipo.getItemAt(0)) || operadora.equals(cbxOperadora.getItemAt(0))) {
            JOptionPane.showMessageDialog(this, "Llene todo");
        } else {
            controladorUsuario.actualizarTelefono(codigo, numero, tipo, operadora);
            JOptionPane.showMessageDialog(this, "Teléfono actualizado ");
            cargarTelefonosTblTelefonos();
            btnAgregar.setEnabled(true);
            btnCancelar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
            limpiar();

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnAgregar.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Desea eliminarlo");
        if (op == 0) {
            controladorUsuario.eliminarTelefono(Integer.parseInt(txtCodigo.getText()));
            cargarTelefonosTblTelefonos();
            limpiar();
            desactivarEdicion();
            btnAgregar.setEnabled(true);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed
    public void limpiar() {
        txtCodigo.setText("");
        txtNumero.setValue("");
        cbxTipo.setSelectedItem(0);
        cbxOperadora.setSelectedItem(0);
        cargarSiguienteCodigo();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxOperadora;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
