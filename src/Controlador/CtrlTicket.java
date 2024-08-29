
package Controlador;

import Modelo.ConsultaTicket;
import Modelo.ticket;
import Visual.comprarEntrada;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CtrlTicket implements ActionListener{
      private final ticket modelo;
    private final ConsultaTicket consultas;
    private final comprarEntrada Visual;

    public CtrlTicket(ticket modelo, ConsultaTicket consultas, comprarEntrada Visual) throws SQLException {
        this.modelo = modelo;
        this.consultas = consultas;
        this.Visual = Visual;
        this.Visual.btnConfirmar.addActionListener((ActionListener) this);
        this.Visual.PeliculasBOX.addActionListener((ActionListener) this); 
    }

    public void iniciar() {
        Visual.setTitle("Ticket");
        Visual.setLocationRelativeTo(null); //Formulario en el centro
        Visual.setVisible(false);  //campo id invisible

    }

    public void limpiar() {
        Visual.txtNombre.setText(null);
        Visual.txtCorreo.setText(null);
        Visual.txtEntradas.setText(null);
    }
    
  

     @Override
    public void actionPerformed(ActionEvent e) {
        //boton de guardar
        if (e.getSource() == Visual.btnConfirmar) {
            modelo.setCedula(1);
            modelo.setNombre(Visual.txtNombre.getText());
            modelo.setCorreo(Visual.txtCorreo.getText());
            modelo.setCantidadEntradas(Integer.parseInt(Visual.txtEntradas.getText()));
            modelo.setPelicula(Visual.PeliculasBOX.getName());
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Resgistro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
    }
    public void buscar() {
        
    }
}
