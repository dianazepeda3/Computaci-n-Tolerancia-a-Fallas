
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * @author diana zepeda tatengo
 */
public class main extends javax.swing.JFrame {

    GuardarCanciones guardar;
    Cancion song;
    
    String url = "canciones.txt";
    Object[][] canciones = new Object[50][3]; 
    
    public main() throws FileNotFoundException {
        initComponents();
        Color negro = new Color(45, 45, 45);
        this.getContentPane().setBackground(negro); //Cambiar color de fond
        guardar = new GuardarCanciones();
        song  = new Cancion();        
        try{
            guardar.CrearArchivo(url);
            song = guardar.getRespaldo();
            txtNombre.setText(song.getNombre());
            txtArtista.setText(song.getArtista());
            txtAlbum.setText(song.getAlbum());
        }catch (Exception e){}
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Boolean aux = true;
        int i=0;
        canciones = guardar.getCanciones(url);
        while(aux){
            if(String.valueOf(canciones[i][0]).equals("null")){
                aux = false; 
            }else{
                modelo.addRow(new Object[]{canciones[i][0],canciones[i][1],canciones[i][2]});   
            }
            i++;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTittulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtArtista = new javax.swing.JTextField();
        txtAlbum = new javax.swing.JTextField();
        jlNombre2 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlNombre3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblTittulo1 = new javax.swing.JLabel();
        jlNombre1 = new javax.swing.JLabel();
        jlNombre4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTittulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        lblTittulo.setForeground(new java.awt.Color(255, 255, 102));
        lblTittulo.setText("RESTAURAR ESTADO DE EJECUCIÓN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Artista", "Album"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(58, 58, 58));
        jPanel3.setLayout(null);

        txtNombre.setBackground(new java.awt.Color(234, 234, 234));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel3.add(txtNombre);
        txtNombre.setBounds(100, 20, 200, 30);

        txtArtista.setBackground(new java.awt.Color(234, 234, 234));
        txtArtista.setForeground(new java.awt.Color(0, 0, 0));
        txtArtista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtistaKeyPressed(evt);
            }
        });
        jPanel3.add(txtArtista);
        txtArtista.setBounds(100, 90, 200, 30);

        txtAlbum.setBackground(new java.awt.Color(234, 234, 234));
        txtAlbum.setForeground(new java.awt.Color(0, 0, 0));
        txtAlbum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlbumKeyPressed(evt);
            }
        });
        jPanel3.add(txtAlbum);
        txtAlbum.setBounds(100, 160, 200, 30);

        jlNombre2.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jlNombre2.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre2.setText("Artista:");
        jPanel3.add(jlNombre2);
        jlNombre2.setBounds(20, 100, 144, 19);

        jlNombre.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setText("Álbum:");
        jPanel3.add(jlNombre);
        jlNombre.setBounds(20, 170, 144, 19);

        jlNombre3.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jlNombre3.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre3.setText("Nombre:");
        jPanel3.add(jlNombre3);
        jlNombre3.setBounds(20, 30, 144, 19);

        btnGuardar.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTittulo1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblTittulo1.setForeground(new java.awt.Color(255, 153, 0));
        lblTittulo1.setText("INFORMACIÓN DE CANCIÓN");

        jlNombre1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jlNombre1.setForeground(new java.awt.Color(255, 255, 255));

        jlNombre4.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jlNombre4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jlNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jlNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTittulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTittulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jlNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jlNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(txtNombre.getText().isEmpty() && txtArtista.getText().isEmpty() && txtAlbum.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ningun campo pude quedar vacío");
            }else{
                guardar = new GuardarCanciones();
                guardar.Guardar(txtNombre.getText(), txtArtista.getText(), txtAlbum.getText(), url);
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                modelo.addRow(new Object[]{txtNombre.getText(), txtArtista.getText(), txtAlbum.getText()});
                
                txtNombre.setText(null); 
                txtArtista.setText(null); 
                txtAlbum.setText(null);
                guardar.borrarRespaldo();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        guardar = new GuardarCanciones();
        try {
            guardar.Respaldo(txtNombre.getText(), txtArtista.getText(), txtAlbum.getText());            
        } catch (IOException ex) {}
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtArtistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtistaKeyPressed
        guardar = new GuardarCanciones();
        try {
            guardar.Respaldo(txtNombre.getText(), txtArtista.getText(), txtAlbum.getText());            
        } catch (IOException ex) {}
    }//GEN-LAST:event_txtArtistaKeyPressed

    private void txtAlbumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlbumKeyPressed
        guardar = new GuardarCanciones();
        try {
            guardar.Respaldo(txtNombre.getText(), txtArtista.getText(), txtAlbum.getText());                                
        } catch (IOException ex) {}
    }//GEN-LAST:event_txtAlbumKeyPressed

   
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main().setVisible(true); // Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    //Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNombre1;
    private javax.swing.JLabel jlNombre2;
    private javax.swing.JLabel jlNombre3;
    private javax.swing.JLabel jlNombre4;
    private javax.swing.JLabel lblTittulo;
    private javax.swing.JLabel lblTittulo1;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtArtista;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
