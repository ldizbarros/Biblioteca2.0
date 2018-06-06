package bilbioteca2.aplicacion;

import bilbioteca2.metodos.MetodosGUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import libreria.Biblioteca;

/**
 *
 * @author laudi
 */
public class VentanaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaUsuario
     */
    DefaultTableModel tabla = new DefaultTableModel();
    
    public VentanaUsuario() {
        initComponents();
        this.setLocationRelativeTo(this);
        jRB_Autor.setVisible(false);
        jRB_Editorial.setVisible(false);
        jRB_ISBN.setVisible(false);
        jRB_Publicacion.setVisible(false);
        jRB_Seccion.setVisible(false);
        jRB_Titulo.setVisible(false);
        jLabel_codUsuario.setVisible(false);
        jB_aumento.setText("<html><p>Aumentar</p><p>Prestamo</p></html>");
        jB_verLibro.setText("<html><p>Ficha</p><p>Libro</p></html>");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_MostrarLibros = new javax.swing.JTable();
        jLabel_buscador = new javax.swing.JLabel();
        jTF_Busqueda = new javax.swing.JTextField();
        jL_mostarFiltros = new javax.swing.JLabel();
        jRB_Autor = new javax.swing.JRadioButton();
        jRB_Titulo = new javax.swing.JRadioButton();
        jRB_Editorial = new javax.swing.JRadioButton();
        jRB_ISBN = new javax.swing.JRadioButton();
        jRB_Publicacion = new javax.swing.JRadioButton();
        jRB_Seccion = new javax.swing.JRadioButton();
        jLabel_Cerrar = new javax.swing.JLabel();
        jL_Buscar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jB_prestamos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Prestamos = new javax.swing.JTable();
        jLabel_codUsuario = new javax.swing.JLabel();
        jB_verLibro = new javax.swing.JButton();
        jB_aumento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Usuario");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("activeCaption"));

        jLabel_Usuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Usuario.setText("Usuario");

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

        jLabel_buscador.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel_buscador.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_buscador.setText("BUSCADOR:");

        jTF_Busqueda.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        jL_mostarFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/mostrar.png"))); // NOI18N
        jL_mostarFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_mostarFiltrosMouseClicked(evt);
            }
        });

        jRB_Autor.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Autor.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Autor.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Autor.setText("Autor");

        jRB_Titulo.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Titulo.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Titulo.setText("Titulo");

        jRB_Editorial.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Editorial.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Editorial.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Editorial.setText("Editorial");

        jRB_ISBN.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_ISBN.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_ISBN.setForeground(new java.awt.Color(255, 255, 255));
        jRB_ISBN.setText("ISBN");

        jRB_Publicacion.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Publicacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Publicacion.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Publicacion.setText("Año Publicacion");

        jRB_Seccion.setBackground(javax.swing.UIManager.getDefaults().getColor("RadioButton.shadow"));
        jRB_Seccion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jRB_Seccion.setForeground(new java.awt.Color(255, 255, 255));
        jRB_Seccion.setText("Seccion");

        jLabel_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/close.png"))); // NOI18N
        jLabel_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CerrarMouseClicked(evt);
            }
        });

        jL_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilbioteca2/aplicacion/iconos/search.png"))); // NOI18N
        jL_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_BuscarMouseClicked(evt);
            }
        });

        jB_prestamos.setBackground(java.awt.SystemColor.controlHighlight);
        jB_prestamos.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jB_prestamos.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jB_prestamos.setText("PRESTAMOS");
        jB_prestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_prestamosActionPerformed(evt);
            }
        });

        jTable_Prestamos.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jTable_Prestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LIBRO", "FECHA DEVOLUCION", "AUMENTO"
            }
        ));
        jScrollPane2.setViewportView(jTable_Prestamos);

        jLabel_codUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel_codUsuario.setForeground(new java.awt.Color(255, 255, 255));

        jB_verLibro.setBackground(java.awt.SystemColor.controlHighlight);
        jB_verLibro.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jB_verLibro.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jB_verLibro.setText("Ver Ficha");
        jB_verLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_verLibroActionPerformed(evt);
            }
        });

        jB_aumento.setBackground(java.awt.SystemColor.controlHighlight);
        jB_aumento.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jB_aumento.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        jB_aumento.setText("Aumentar");
        jB_aumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_aumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_codUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Usuario)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jB_prestamos)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_buscador)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTF_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jL_Buscar)
                                        .addGap(128, 128, 128)
                                        .addComponent(jL_mostarFiltros))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                        .addComponent(jRB_Seccion)
                                        .addGap(30, 30, 30)))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_aumento)
                            .addComponent(jB_verLibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Cerrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Usuario)
                    .addComponent(jLabel_codUsuario))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTF_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_buscador)
                            .addComponent(jL_Buscar)
                            .addComponent(jL_mostarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRB_Autor)
                            .addComponent(jRB_Titulo)
                            .addComponent(jRB_Editorial)
                            .addComponent(jRB_ISBN)
                            .addComponent(jRB_Publicacion)
                            .addComponent(jRB_Seccion))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jB_verLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jB_aumento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jB_prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Cerrar)
                        .addContainerGap())))
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
                    JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
                }
            }
        }
    }//GEN-LAST:event_jL_BuscarMouseClicked

    private void jB_prestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_prestamosActionPerformed
        ArrayList prestamos = MetodosGUI.verPrestamos(Integer.parseInt(jLabel_codUsuario.getText()));
        jTable_Prestamos.setModel(MetodosGUI.mostrarPrestamos(prestamos));
        TableColumn columna =  jTable_Prestamos.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        jTable_Prestamos.doLayout();   
    }//GEN-LAST:event_jB_prestamosActionPerformed

    private void jB_verLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_verLibroActionPerformed
        try{
            String codLibro =  (String) jTable_MostrarLibros.getValueAt(jTable_MostrarLibros.getSelectedRow(), 0);
            MetodosGUI.mostrarLibro(codLibro);
        }catch(ArrayIndexOutOfBoundsException ex){
            Biblioteca.mostrarMensaje("No ha seleccionado ningun libro.\nPor favor selecione uno para poder mostrar su ficha.");
        }
    }//GEN-LAST:event_jB_verLibroActionPerformed

    private void jB_aumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_aumentoActionPerformed
        try{
            String codPrestamo =  (String) jTable_Prestamos.getValueAt(jTable_Prestamos.getSelectedRow(), 0);
            MetodosGUI.aumetarPrestamo(codPrestamo);
            ArrayList prestamos = MetodosGUI.verPrestamos(Integer.parseInt(jLabel_codUsuario.getText()));
            jTable_Prestamos.setModel(MetodosGUI.mostrarPrestamos(prestamos));
            TableColumn columna =  jTable_Prestamos.getColumnModel().getColumn(0);
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            jTable_Prestamos.doLayout();
        }catch(ArrayIndexOutOfBoundsException ex){
            Biblioteca.mostrarMensaje("No ha seleccionado ningun prestamo.\nPor favor selecione uno para poder aumentar el plazo de devolucion.");
        }
    }//GEN-LAST:event_jB_aumentoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_aumento;
    private javax.swing.JButton jB_prestamos;
    private javax.swing.JButton jB_verLibro;
    private javax.swing.JLabel jL_Buscar;
    private javax.swing.JLabel jL_mostarFiltros;
    private javax.swing.JLabel jLabel_Cerrar;
    public static javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JLabel jLabel_buscador;
    public static javax.swing.JLabel jLabel_codUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRB_Autor;
    private javax.swing.JRadioButton jRB_Editorial;
    private javax.swing.JRadioButton jRB_ISBN;
    private javax.swing.JRadioButton jRB_Publicacion;
    private javax.swing.JRadioButton jRB_Seccion;
    private javax.swing.JRadioButton jRB_Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTF_Busqueda;
    private javax.swing.JTable jTable_MostrarLibros;
    private javax.swing.JTable jTable_Prestamos;
    // End of variables declaration//GEN-END:variables
}
