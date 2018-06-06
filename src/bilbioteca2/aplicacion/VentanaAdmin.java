/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca2.aplicacion;

import bilbioteca2.metodos.MetodosGUI;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import libreria.Biblioteca;

/**
 *
 * @author laudi
 */
public class VentanaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdmin
     */
    DefaultTableModel tabla = new DefaultTableModel();
    
    public VentanaAdmin() {
        initComponents();
        this.setLocationRelativeTo(this);
        jRB_Autor.setVisible(false);
        jRB_Editorial.setVisible(false);
        jRB_ISBN.setVisible(false);
        jRB_Publicacion.setVisible(false);
        jRB_Seccion.setVisible(false);
        jRB_Titulo.setVisible(false);
        jB_verLibro.setText("<html><p>Ficha</p><p>Libro</p></html>");
        jNuevoPrestamo.setText("<html><p>Nuevo</p><p>Prestamo</p></html>");
        JEliminarUsuario.setText("<html><p>Eliminar</p><p>Usuario</p></html>");
        jAñadirUsuario.setText("<html><p>Nuevo</p><p>Usuario</p></html>");
        jDevolverPrestamo.setText("<html><p>Devolver</p><p>Prestamo</p></html>");
        jAñadirLibro.setText("<html><p>Nuevo</p><p>Libro</p></html>");
        jBorrarLibro.setText("<html><p>Eliminar</p><p>Libro</p></html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Usuario = new javax.swing.JLabel();
        jAñadirUsuario = new javax.swing.JButton();
        JEliminarUsuario = new javax.swing.JButton();
        jNuevoPrestamo = new javax.swing.JButton();
        jDevolverPrestamo = new javax.swing.JButton();
        jLabel_buscador = new javax.swing.JLabel();
        jTF_Busqueda = new javax.swing.JTextField();
        jL_Buscar = new javax.swing.JLabel();
        jL_mostarFiltros = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRB_Seccion = new javax.swing.JRadioButton();
        jRB_Publicacion = new javax.swing.JRadioButton();
        jRB_ISBN = new javax.swing.JRadioButton();
        jRB_Editorial = new javax.swing.JRadioButton();
        jRB_Titulo = new javax.swing.JRadioButton();
        jRB_Autor = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_MostrarLibros = new javax.swing.JTable();
        jLabel_Cerrar = new javax.swing.JLabel();
        jB_verLibro = new javax.swing.JButton();
        jAñadirLibro = new javax.swing.JButton();
        jBorrarLibro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Administrador");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("activeCaption"));

        jLabel_Usuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Usuario.setText("Usuario");

        jAñadirUsuario.setBackground(java.awt.SystemColor.controlHighlight);
        jAñadirUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jAñadirUsuario.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jAñadirUsuario.setText("AÑADIR U");
        jAñadirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAñadirUsuarioActionPerformed(evt);
            }
        });

        JEliminarUsuario.setBackground(java.awt.SystemColor.controlHighlight);
        JEliminarUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        JEliminarUsuario.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        JEliminarUsuario.setText("ELIMINAR U");
        JEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarUsuarioActionPerformed(evt);
            }
        });

        jNuevoPrestamo.setBackground(java.awt.SystemColor.controlHighlight);
        jNuevoPrestamo.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jNuevoPrestamo.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jNuevoPrestamo.setText("NUEVO PRES");
        jNuevoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevoPrestamoActionPerformed(evt);
            }
        });

        jDevolverPrestamo.setBackground(java.awt.SystemColor.controlHighlight);
        jDevolverPrestamo.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jDevolverPrestamo.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jDevolverPrestamo.setText("DEVOLVER PRES");
        jDevolverPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDevolverPrestamoActionPerformed(evt);
            }
        });

        jLabel_buscador.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel_buscador.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_buscador.setText("BUSCADOR:");

        jTF_Busqueda.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        jL_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/search.png"))); // NOI18N
        jL_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_BuscarMouseClicked(evt);
            }
        });

        jL_mostarFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/mostrar.png"))); // NOI18N
        jL_mostarFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_mostarFiltrosMouseClicked(evt);
            }
        });

        jRB_Seccion.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Seccion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Seccion.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Seccion.setText("Seccion");

        jRB_Publicacion.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Publicacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Publicacion.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Publicacion.setText("Año Publicacion");

        jRB_ISBN.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_ISBN.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_ISBN.setForeground(new java.awt.Color(255, 255, 255));
        jRB_ISBN.setText("ISBN");

        jRB_Editorial.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Editorial.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Editorial.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Editorial.setText("Editorial");

        jRB_Titulo.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Titulo.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Titulo.setText("Titulo");

        jRB_Autor.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Autor.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Autor.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Autor.setText("Autor");

        jTable_MostrarLibros.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jTable_MostrarLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "TITULO", "AUTOR", "EDITORIAL", "ISBN", "AÑO PUBLICACION", "SECCION", "EJEMPLARES DISPONIBLES"
            }
        ));
        jScrollPane1.setViewportView(jTable_MostrarLibros);

        jLabel_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/close.png"))); // NOI18N
        jLabel_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CerrarMouseClicked(evt);
            }
        });

        jB_verLibro.setBackground(java.awt.SystemColor.controlHighlight);
        jB_verLibro.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jB_verLibro.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jB_verLibro.setText("Ver Ficha");
        jB_verLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_verLibroActionPerformed(evt);
            }
        });

        jAñadirLibro.setBackground(java.awt.SystemColor.controlHighlight);
        jAñadirLibro.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jAñadirLibro.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jAñadirLibro.setText("AÑADIR LIBRO");
        jAñadirLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAñadirLibroActionPerformed(evt);
            }
        });

        jBorrarLibro.setBackground(java.awt.SystemColor.controlHighlight);
        jBorrarLibro.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jBorrarLibro.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jBorrarLibro.setText("BORRAR LIBRO");
        jBorrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jRB_Autor)
                        .addGap(35, 35, 35)
                        .addComponent(jRB_Titulo)
                        .addGap(42, 42, 42)
                        .addComponent(jRB_Editorial)
                        .addGap(40, 40, 40)
                        .addComponent(jRB_ISBN)
                        .addGap(39, 39, 39)
                        .addComponent(jRB_Publicacion)
                        .addGap(39, 39, 39)
                        .addComponent(jRB_Seccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_buscador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jL_Buscar)
                                .addGap(95, 95, 95)
                                .addComponent(jL_mostarFiltros))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBorrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jB_verLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAñadirLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jAñadirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(JEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jNuevoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jDevolverPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel_Cerrar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Usuario)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Usuario)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_buscador)
                    .addComponent(jL_Buscar)
                    .addComponent(jL_mostarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB_Autor)
                    .addComponent(jRB_Titulo)
                    .addComponent(jRB_Editorial)
                    .addComponent(jRB_ISBN)
                    .addComponent(jRB_Publicacion)
                    .addComponent(jRB_Seccion))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jB_verLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBorrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jAñadirLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel_Cerrar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDevolverPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNuevoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAñadirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAñadirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAñadirUsuarioActionPerformed
        AñadirUsuario socio = new AñadirUsuario();
        socio.setVisible(true);
    }//GEN-LAST:event_jAñadirUsuarioActionPerformed

    private void JEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarUsuarioActionPerformed
        EliminarUsuario socio = new EliminarUsuario();
        socio.setVisible(true);
    }//GEN-LAST:event_JEliminarUsuarioActionPerformed

    private void jNuevoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevoPrestamoActionPerformed
        AñadirPrestamo prestamo = new AñadirPrestamo();
        prestamo.setVisible(true);
    }//GEN-LAST:event_jNuevoPrestamoActionPerformed

    private void jDevolverPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDevolverPrestamoActionPerformed
        DevolverPrestamo prestamo = new DevolverPrestamo();
        prestamo.setVisible(true);
    }//GEN-LAST:event_jDevolverPrestamoActionPerformed

    private void jL_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_BuscarMouseClicked
        if (jTF_Busqueda.getText().equalsIgnoreCase("")){
            Biblioteca.mostrarMensaje("No se ha introducido ningun criterio de busqueda.");
        }else{
            String filtro = "";
            int count = 0;
            if (jRB_Autor.isSelected()){
                filtro="autor";
                count+=1;
            }
            if (jRB_Titulo.isSelected()){
                filtro="titulo";
                count+=1;
            }
            if (jRB_Editorial.isSelected()){
                filtro="editorial";
                count+=1;
            }
            if (jRB_ISBN.isSelected()){
                filtro="isbn";
                count+=1;
            }
            if(jRB_Publicacion.isSelected()){
                filtro="publicacion";
                count+=1;
            }
            if(jRB_Seccion.isSelected()){
                filtro="seccion";
                count+=1;
            }
            if (count>1){
                Biblioteca.mostrarMensaje("A seleccionado mas de un filtro.\nPor favor seleccione un filtro por busqueda");
            }else{
                for (int i=0; i<tabla.getRowCount();i++){
                    tabla.removeRow(i);
                    i-=1;
                }
                ArrayList libros = MetodosGUI.busqueda(jTF_Busqueda.getText(),filtro);
                if (!libros.isEmpty()){
                    jTable_MostrarLibros.setModel(MetodosGUI.mostrarLibros(libros));
                    TableColumn columna =  jTable_MostrarLibros.getColumnModel().getColumn(0);
                    columna.setMaxWidth(0);
                    columna.setMinWidth(0);
                    columna.setPreferredWidth(0);
                    jTable_MostrarLibros.doLayout();
                }else{
                    Biblioteca.mostrarMensaje("No se han encontrado coincidencias");
                }
            }
        }
    }//GEN-LAST:event_jL_BuscarMouseClicked

    private void jL_mostarFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_mostarFiltrosMouseClicked
        jRB_Autor.setVisible(true);
        jRB_Editorial.setVisible(true);
        jRB_ISBN.setVisible(true);
        jRB_Publicacion.setVisible(true);
        jRB_Seccion.setVisible(true);
        jRB_Titulo.setVisible(true);
    }//GEN-LAST:event_jL_mostarFiltrosMouseClicked

    private void jLabel_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CerrarMouseClicked
        MetodosGUI.cerrarSesion();
        this.setVisible(false);
    }//GEN-LAST:event_jLabel_CerrarMouseClicked

    private void jB_verLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_verLibroActionPerformed
        try{
            String codLibro =  (String) jTable_MostrarLibros.getValueAt(jTable_MostrarLibros.getSelectedRow(), 0);
            MetodosGUI.mostrarLibroAdmin(codLibro);
        }catch(ArrayIndexOutOfBoundsException ex){
            Biblioteca.mostrarMensaje("No ha seleccionado ningun libro.\nPor favor selecione uno para poder mostrar su ficha.");
        }
    }//GEN-LAST:event_jB_verLibroActionPerformed

    private void jAñadirLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAñadirLibroActionPerformed
        AñadirLibro libro = new AñadirLibro();
        libro.setVisible(true);
    }//GEN-LAST:event_jAñadirLibroActionPerformed

    private void jBorrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarLibroActionPerformed
        
    }//GEN-LAST:event_jBorrarLibroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JEliminarUsuario;
    private javax.swing.JButton jAñadirLibro;
    private javax.swing.JButton jAñadirUsuario;
    private javax.swing.JButton jB_verLibro;
    private javax.swing.JButton jBorrarLibro;
    private javax.swing.JButton jDevolverPrestamo;
    private javax.swing.JLabel jL_Buscar;
    private javax.swing.JLabel jL_mostarFiltros;
    private javax.swing.JLabel jLabel_Cerrar;
    public static javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JLabel jLabel_buscador;
    private javax.swing.JButton jNuevoPrestamo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRB_Autor;
    private javax.swing.JRadioButton jRB_Editorial;
    private javax.swing.JRadioButton jRB_ISBN;
    private javax.swing.JRadioButton jRB_Publicacion;
    private javax.swing.JRadioButton jRB_Seccion;
    private javax.swing.JRadioButton jRB_Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTF_Busqueda;
    private javax.swing.JTable jTable_MostrarLibros;
    // End of variables declaration//GEN-END:variables
}
