package traveller.interfaz.panel;

import traveller.dominio.Viaje;
import traveller.dominio.ISistema;
import traveller.dominio.TipoEvento;
import traveller.excepciones.evento.EventoException;
import traveller.excepciones.fecha.FechaException;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.border.LineBorder;

/**
 * La clase PanelJugadores se encarga de pedir y validar los datos para la
 * creación de nuevos jugadores y de mostrar los datos de jugadores existentes.
 */
public class PanelNuevoEvento extends javax.swing.JPanel {

    /**
     * Crea un nuevo objeto PanelJugadores
     */
    public PanelNuevoEvento(ISistema sistema) {
        initComponents();

        this.etqOtroEvento.setVisible(false);
        this.txtOtroEvento.setVisible(false);
        
        this.sistema = sistema;

        ArrayList<Viaje> lista = new ArrayList<Viaje>();
        Iterator<Viaje> it = sistema.getUsuarioIdentificado().getListaViajes().iterator();
        while (it.hasNext()) {
            lista.add(it.next());
        }
        listaViajes.setListData(lista.toArray());
         if (this.sistema.esModoDesarrollador()) {
            this.txtNombre.requestFocusInWindow();
            this.txtNombre.setText("Paseo al museo");
            this.txtDescripcion.setText("Visita al Museo Thyssen-Bornemisza.");
            this.txtLugar.setText("Museo Thyssen-Bornemisza");
            this.listaViajes.setSelectedIndex(0);
        } else {
            this.txtNombre.requestFocusInWindow();
        }
        
        this.cargarTiposEventos();
    }

    private void cargarTiposEventos(){
        this.comboTipo.removeAll();
        ArrayList<TipoEvento> eventos = this.sistema.getListaEventos();
        for(int i = 0 ; i< eventos.size(); i++){
            this.comboTipo.addItem(eventos.get(i).getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        panelCrearJugador = new javax.swing.JPanel();
        etqTipo = new javax.swing.JLabel();
        etqFecha = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        etqCorrecto = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        etqDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        etqNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        scrollListaViajes = new javax.swing.JScrollPane();
        listaViajes = new javax.swing.JList();
        etqViaje = new javax.swing.JLabel();
        etqLugar = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        etqAclaracion = new javax.swing.JLabel();
        dcFechaEvento = new com.toedter.calendar.JDateChooser();
        etqError = new javax.swing.JLabel();
        txtOtroEvento = new javax.swing.JTextField();
        etqOtroEvento = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(447, 615));

        panelPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(447, 615));

        panelTitulo.setBackground(new java.awt.Color(39, 39, 39));
        panelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        panelTitulo.setPreferredSize(new java.awt.Dimension(91, 36));

        etqTitulo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etqTitulo.setText("Nuevo evento");

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
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelCrearJugador.setBackground(new java.awt.Color(255, 255, 255));
        panelCrearJugador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(39, 39, 39), 1, true));
        panelCrearJugador.setPreferredSize(new java.awt.Dimension(390, 203));
        panelCrearJugador.setVerifyInputWhenFocusTarget(false);

        etqTipo.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqTipo.setText("Tipo:");

        etqFecha.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqFecha.setText("Fecha:");

        btnAceptar.setBackground(new java.awt.Color(242, 242, 242));
        btnAceptar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAceptar.setText("Crear evento");
        btnAceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 221, 221), 1, true));
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        etqCorrecto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqCorrecto.setForeground(new java.awt.Color(0, 153, 0));

        comboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoItemStateChanged(evt);
            }
        });
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        etqDescripcion.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqDescripcion.setText("Descripción:");

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

        etqNombre.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
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

        listaViajes.setFocusable(false);
        listaViajes.setSelectionBackground(new java.awt.Color(39, 39, 39));
        listaViajes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaViajesValueChanged(evt);
            }
        });
        scrollListaViajes.setViewportView(listaViajes);

        etqViaje.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqViaje.setText("Viaje:");

        etqLugar.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqLugar.setText("Lugar:");

        txtLugar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtLugar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarKeyReleased(evt);
            }
        });
        txtLugar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLugar.setBorder(new LineBorder(new Color(77,144,254)));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLugar.setBorder(new LineBorder(new Color(217,217,217)));
            }
        });
        txtLugar.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!txtLugar.isFocusOwner()) {
                    txtLugar.setBorder(new LineBorder(new Color(185, 185, 185)));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!txtLugar.isFocusOwner()) {
                    txtLugar.setBorder(new LineBorder(new Color(217, 217, 217)));
                }
            }
        });

        etqAclaracion.setText("* El proceso de creación del evento prodría demorar unos segundos.");

        etqError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etqError.setForeground(new java.awt.Color(204, 0, 0));

        txtOtroEvento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtOtroEvento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        txtOtroEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtroEventoKeyReleased(evt);
            }
        });
        txtLugar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLugar.setBorder(new LineBorder(new Color(77,144,254)));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLugar.setBorder(new LineBorder(new Color(217,217,217)));
            }
        });
        txtLugar.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!txtLugar.isFocusOwner()) {
                    txtLugar.setBorder(new LineBorder(new Color(185, 185, 185)));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!txtLugar.isFocusOwner()) {
                    txtLugar.setBorder(new LineBorder(new Color(217, 217, 217)));
                }
            }
        });

        etqOtroEvento.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        etqOtroEvento.setText("Otro:");

        javax.swing.GroupLayout panelCrearJugadorLayout = new javax.swing.GroupLayout(panelCrearJugador);
        panelCrearJugador.setLayout(panelCrearJugadorLayout);
        panelCrearJugadorLayout.setHorizontalGroup(
            panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqAclaracion, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etqTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etqFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etqDescripcion)
                                    .addComponent(etqOtroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOtroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 48, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqCorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                                .addComponent(etqLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrearJugadorLayout.createSequentialGroup()
                                    .addComponent(etqViaje)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scrollListaViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrearJugadorLayout.createSequentialGroup()
                                    .addComponent(etqNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(etqError, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelCrearJugadorLayout.setVerticalGroup(
            panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearJugadorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqViaje)
                    .addComponent(scrollListaViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqLugar)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqOtroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaEvento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqFecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearJugadorLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCrearJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqCorrecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etqError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(etqAclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etqDescripcion))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelCrearJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCrearJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(506, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarKeyReleased

    private void listaViajesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaViajesValueChanged
        if (!listaViajes.isSelectionEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaIni = dateFormat.format(((Viaje) listaViajes.getSelectedValue()).getFechaInicio());
            String fechaFin = dateFormat.format(((Viaje) listaViajes.getSelectedValue()).getFechaFin());
           // etqFechas.setText(fechaIni + " - " + fechaFin);
        } else {
            //etqFechas.setText("");
        }
    }//GEN-LAST:event_listaViajesValueChanged

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        TipoEvento tipoEvento = null;
        
        if(comboTipo.getSelectedItem().toString().equalsIgnoreCase("Otro")){
            tipoEvento = new TipoEvento(this.txtOtroEvento.getText());
        }else{
            tipoEvento = new TipoEvento(comboTipo.getSelectedItem().toString());
        }
        
        String nombre = txtNombre.getText();
        Date fecha = dcFechaEvento.getDate();
        String lugar = txtLugar.getText();
        if (!listaViajes.isSelectionEmpty()) {
            String descripcion = txtDescripcion.getText();

            try {
                ((Viaje) listaViajes.getSelectedValue()).altaEvento(nombre, fecha, lugar, descripcion, tipoEvento);
                String accion = "<html><b>" + this.sistema.getUsuarioIdentificado().getNombre() + " "
                + this.sistema.getUsuarioIdentificado().getApellido() + "</b> agregó el evento <i>" + nombre + "</i> al viaje.";
                SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                Date hoy = new Date();
                String strDia = sdfDate.format(hoy);
                ((Viaje) listaViajes.getSelectedValue()).agregarLogAViaje(accion,strDia);
                etqCorrecto.setText("Registro exitoso.");
                this.sistema.agregarTipoEvento(tipoEvento);
                etqError.setText(null);
                inhabilitarCampos();

                String mensaje = this.sistema.getUsuarioIdentificado().getNombre() + " " + this.sistema.getUsuarioIdentificado().getApellido() + " agrego el evento " + nombre + " al viaje " +
                ((Viaje) listaViajes.getSelectedValue()).getNombre();

                String mensajeEmail = "Le notificamos que el usuario "+this.sistema.getUsuarioIdentificado().getNombre() + " " + this.sistema.getUsuarioIdentificado().getApellido() + " agrego el evento " + nombre + " al viaje " +
                ((Viaje) listaViajes.getSelectedValue()).getNombre() + "\n\n Le recordamos que si no desea ser notificado mediante este medio puede darse"
                + "de baja seleccionando la opción en 'Mi Cuenta' \n\nGracias,\n\nTraveller.";
                String titulo = this.sistema.getUsuarioIdentificado().getNombre() + " "+this.sistema.getUsuarioIdentificado().getApellido() + " ha modificado un viaje.";
                this.sistema.notificarNovedad(mensaje, mensajeEmail, titulo, (Viaje) listaViajes.getSelectedValue());

            } catch (EventoException e) {
                etqError.setText(e.toString());
            } catch (FechaException e) {
                etqError.setText(e.toString());
            }
        } else {
            etqError.setText("Debe seleccionar un viaje.");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtOtroEventoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroEventoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtroEventoKeyReleased

    private void comboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoItemStateChanged
        String tipoEvento = comboTipo.getSelectedItem().toString();
        if(tipoEvento.equalsIgnoreCase("Otro")){
            this.txtOtroEvento.setVisible(true);
            this.etqOtroEvento.setVisible(true);
            this.txtOtroEvento.setText("");
        }else{
            this.txtOtroEvento.setVisible(false);
            this.etqOtroEvento.setVisible(false);
            this.txtOtroEvento.setText("");
        }
    }//GEN-LAST:event_comboTipoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox comboTipo;
    private com.toedter.calendar.JDateChooser dcFechaEvento;
    private javax.swing.JLabel etqAclaracion;
    private javax.swing.JLabel etqCorrecto;
    private javax.swing.JLabel etqDescripcion;
    private javax.swing.JLabel etqError;
    private javax.swing.JLabel etqFecha;
    private javax.swing.JLabel etqLugar;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqOtroEvento;
    private javax.swing.JLabel etqTipo;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel etqViaje;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaViajes;
    private javax.swing.JPanel panelCrearJugador;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollListaViajes;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtroEvento;
    // End of variables declaration//GEN-END:variables
    private ISistema sistema;

    /**
     * Inhabilita los campos de ingeso de datos.
     */
    private void inhabilitarCampos() {
        txtNombre.setEditable(false);
        txtLugar.setEditable(false);
        txtDescripcion.setEditable(false);
        btnAceptar.setEnabled(false);
    }
}
