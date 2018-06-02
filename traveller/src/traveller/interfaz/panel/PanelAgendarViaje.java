package traveller.interfaz.panel;

import traveller.dominio.ISistema;
import traveller.dominio.Ciudad;
import traveller.excepciones.fecha.FechaException;
import traveller.excepciones.viaje.ViajeException;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.util.*;
/**
 *
 */
public class PanelAgendarViaje extends javax.swing.JPanel {

    public PanelAgendarViaje(ISistema sistema) {
        initComponents();

        this.etqOtroCiudad.setVisible(false);
        this.txtOtroCiudad.setVisible(false);
        
        this.sistema = sistema;
        if (this.sistema.esModoDesarrollador()) {
            this.txtNombre.requestFocusInWindow();
            this.txtNombre.setText("Vacaciones");
            this.txtDescripcion.setText("Nos vamos de vacaciones con la familia.");
            this.jDateChooser1.setDate(null);
        } else {
            this.txtNombre.requestFocusInWindow();
        }
        
        this.cargarCiudades();
    }

    private void cargarCiudades(){
        this.comboDestino.removeAll();
        ArrayList<Ciudad> ciudades = this.sistema.getListaCiudades();
        for(int i = 0 ; i< ciudades.size(); i++){
            this.comboDestino.addItem(ciudades.get(i).getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        panelCrearJugador = new javax.swing.JPanel();
        etqDestino = new javax.swing.JLabel();
        etqFechaIni = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        etqError = new javax.swing.JLabel();
        etqCorrecto = new javax.swing.JLabel();
        comboDestino = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etqFechaFin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etqDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        etqNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        txtOtroCiudad = new javax.swing.JTextField();
        etqOtroCiudad = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(455, 606));

        panelPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        panelPrincipal.setName(""); // NOI18N
        panelPrincipal.setPreferredSize(new java.awt.Dimension(390, 203));

        panelTitulo.setBackground(new java.awt.Color(39, 39, 39));
        panelTitulo.setForeground(new java.awt.Color(255, 255, 255));

        etqTitulo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etqTitulo.setText("Agendar viaje");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCrearJugador.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearJugador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(39, 39, 39), 1, true));
        panelCrearJugador.setPreferredSize(new java.awt.Dimension(380, 290));

        etqDestino.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqDestino.setText("Destino:");

        etqFechaIni.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqFechaIni.setText("Fecha inicio:");

        btnAceptar.setBackground(new java.awt.Color(242, 242, 242));
        btnAceptar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAceptar.setText("Agendar");
        btnAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 221, 221), 1, true));
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        etqError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        etqError.setForeground(new java.awt.Color(204, 0, 0));
        etqError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etqCorrecto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqCorrecto.setForeground(new java.awt.Color(0, 153, 0));

        comboDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDestinoItemStateChanged(evt);
            }
        });
        comboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDestinoActionPerformed(evt);
            }
        });

        etqFechaFin.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqFechaFin.setText("Fecha fin:");

        etqDescripcion.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqDescripcion.setText("Descripción:");

        txtDescripcion.setText("Vamos toda la familia de vacaciones.");
        jScrollPane2.setViewportView(txtDescripcion);
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcion.setBorder(new LineBorder(new Color(77,144,254)));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcion.setBorder(new LineBorder(new Color(217,217,217)));
            }
        });
        txtDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!txtDescripcion.isFocusOwner()) {
                    txtDescripcion.setBorder(new LineBorder(new Color(185, 185, 185)));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!txtDescripcion.isFocusOwner()) {
                    txtDescripcion.setBorder(new LineBorder(new Color(217, 217, 217)));
                }
            }
        });

        etqNombre.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre.setBorder(new LineBorder(new Color(77,144,254)));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre.setBorder(new LineBorder(new Color(217,217,217)));
            }
        });
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!txtNombre.isFocusOwner()) {
                    txtNombre.setBorder(new LineBorder(new Color(185, 185, 185)));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!txtNombre.isFocusOwner()) {
                    txtNombre.setBorder(new LineBorder(new Color(217, 217, 217)));
                }
            }
        });

        txtOtroCiudad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtOtroCiudad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        txtOtroCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtroCiudadKeyReleased(evt);
            }
        });
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre.setBorder(new LineBorder(new Color(77,144,254)));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre.setBorder(new LineBorder(new Color(217,217,217)));
            }
        });
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!txtNombre.isFocusOwner()) {
                    txtNombre.setBorder(new LineBorder(new Color(185, 185, 185)));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!txtNombre.isFocusOwner()) {
                    txtNombre.setBorder(new LineBorder(new Color(217, 217, 217)));
                }
            }
        });

        etqOtroCiudad.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        etqOtroCiudad.setText("Otro:");

        javax.swing.GroupLayout panelCrearJugadorLayout = new javax.swing.GroupLayout(panelCrearJugador);
        panelCrearJugador.setLayout(panelCrearJugadorLayout);
        panelCrearJugadorLayout.setHorizontalGroup(
            panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqError, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqCorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etqFechaIni)
                            .addComponent(etqFechaFin)
                            .addComponent(etqDescripcion)
                            .addComponent(etqNombre)
                            .addComponent(etqOtroCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(comboDestino, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dcFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(dcFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtOtroCiudad, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(64, 64, 64)
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panelCrearJugadorLayout.setVerticalGroup(
            panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOtroCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(5, 5, 5)))
                        .addGap(19, 19, 19)
                        .addComponent(dcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addComponent(etqOtroCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etqFechaIni)))
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearJugadorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etqFechaFin))
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(dcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqDescripcion)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(etqCorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelCrearJugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCrearJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void comboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDestinoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Ciudad tipoCiudad = null;
        
        if(comboDestino.getSelectedItem().toString().equalsIgnoreCase("Otro")){
            tipoCiudad = new Ciudad(this.txtOtroCiudad.getText());
        }else{
            tipoCiudad = new Ciudad(this.comboDestino.getSelectedItem().toString());
        }

        String nombre = txtNombre.getText();

        //        String diaIni = txtDiaIni.getText();
        //        String mesIni = txtMesIni.getText();
        //        String añoIni = txtAñoIni.getTferSlamovitzext();
        //        String diaFin = txtDiaFin.getText();
        //        String mesFin = txtMesFin.getText();
        //        String añoFin = txtAñoFin.getText();

        String descripcion = txtDescripcion.getText();

        try {
            sistema.getUsuarioIdentificado().altaViaje(nombre, tipoCiudad,dcFechaInicio.getDate(), dcFechaFin.getDate(), descripcion);
            etqCorrecto.setText("Registro exitoso.");
            this.sistema.agregarCiudad(tipoCiudad);
            etqError.setText(null);
            this.inhabilitarCampos();
        } catch (ViajeException e) {
            etqError.setText(e.toString());
        } catch (FechaException e) {
            etqError.setText(e.toString());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtOtroCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroCiudadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtroCiudadKeyReleased

    private void comboDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDestinoItemStateChanged
        String ciudad = comboDestino.getSelectedItem().toString();
        if(ciudad.equalsIgnoreCase("Otro")){
            this.txtOtroCiudad.setVisible(true);
            this.etqOtroCiudad.setVisible(true);
            this.txtOtroCiudad.setText("");
        }else{
            this.txtOtroCiudad.setVisible(false);
            this.etqOtroCiudad.setVisible(false);
            this.txtOtroCiudad.setText("");
        }
    }//GEN-LAST:event_comboDestinoItemStateChanged

    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox comboDestino;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JLabel etqCorrecto;
    private javax.swing.JLabel etqDescripcion;
    private javax.swing.JLabel etqDestino;
    private javax.swing.JLabel etqError;
    private javax.swing.JLabel etqFechaFin;
    private javax.swing.JLabel etqFechaIni;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqOtroCiudad;
    private javax.swing.JLabel etqTitulo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCrearJugador;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtroCiudad;
    // End of variables declaration//GEN-END:variables
    private ISistema sistema;

    /**
     * Inhabilita los campos de ingeso de datos.
     */
    private void inhabilitarCampos() {
        txtDescripcion.setEditable(false);
        txtNombre.setEditable(false);
        btnAceptar.setEnabled(false);
    }
}
