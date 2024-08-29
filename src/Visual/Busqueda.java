/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;

import Modelo.ConsultaTicket;
import Modelo.ticket;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mi161
 */
public class Busqueda extends javax.swing.JFrame {

    /**
     * Creates new form Busqueda
     */
    public Busqueda() {
        initComponents();
        cargarDatos();
       this.setVisible(true);
        ///poner el menu en el centro de la pantalla 
      //  this.setLocationRelativeTo(null);

    }
    
 /*  public void cargarDatos() {
    DefaultTableModel model = (DefaultTableModel) jtTabla.getModel();
    model.setNumRows(0);

    ConsultaTicket consultaTicket = new ConsultaTicket();
    ArrayList<ticket> miListaTicket = consultaTicket.informacionTicket(Integer.parseInt(txtBusqueda.getText()));
    
    for (ticket ticket : miListaTicket) {
        Object[] rowData = {
            ticket.getCantidadEntradas(),
            ticket.getCedula(),
            ticket.getCorreo(),
            ticket.getIVA(),
            ticket.getNombre(),
            ticket.getNumeroTicket(),
            ticket.getPelicula(),
            ticket.getPrecio(),
            ticket.getPrecioTotal()
        };
        model.addRow(rowData);
    }
    jtTabla.setModel(model);
}*/
    
    
   public void cargarDatos() {
   DefaultTableModel model = (DefaultTableModel) jtTabla.getModel();
       model.setNumRows(0);

        ConsultaTicket dArti = new ConsultaTicket();
        ArrayList<ticket> miListaTicket = dArti.todostickets();//trae todo los articulos de la bd
       if (txtBuscar.getText().contentEquals("")) {
            miListaTicket = dArti.todostickets();
       } else {
            miListaTicket = dArti.informacionTicket(Integer.parseInt(txtBuscar.getText()));
       }
        String datos[] = new String[9];
       int i = 0;
     for (ticket tik : miListaTicket) {
            datos[0] = String.valueOf((int)miListaTicket.get(i).getCantidadEntradas());
            datos[1] =String.valueOf( miListaTicket.get(i).getCedula());     
            datos[2] = String.valueOf(miListaTicket.get(i).getCorreo());
             datos[3] = String.valueOf((double)miListaTicket.get(i).getIVA());
              datos[4] = String.valueOf(miListaTicket.get(i).getNombre());
               datos[5] = String.valueOf((int)miListaTicket.get(i).getNumeroTicket());
                datos[6] = String.valueOf(miListaTicket.get(i).getPelicula());
                 datos[7] = String.valueOf((int) miListaTicket.get(i).getPrecio());
                   datos[8] = String.valueOf((int)miListaTicket.get(i).getPrecioTotal());
                   
                 
          i++;
          model.addRow(datos);
      }
      jtTabla.setModel(model);    

   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese el numero de cedula para hacer la busqueda: ");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CantidadEntradas", "Cedula", "Correo", "IVA", "Nombre", "NumeroTicket", "Pelicula", "Precio", "PrecioTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        //txtBusqueda.getText(""); ///limpiar campo 
        txtBuscar.requestFocus(); ///cursor parpadeante
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Busqueda B = new Busqueda();
        ///cargarDatos(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtTabla;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
