/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.usuario;
import Visual.perfilTrabajador;
import Modelo.ConsultaUsuario;
import Visual.Busqueda;
import Visual.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Boolean.TRUE;
import javax.swing.JOptionPane;

/**
 *
 * @author bunoc
 */
public class CtrlUsuario implements ActionListener {

    private final usuario modelo;
    private final ConsultaUsuario consultas;
    private final perfilTrabajador Visual;
    private final Busqueda VisualP = null;

    public CtrlUsuario(usuario modelo, ConsultaUsuario consultas, perfilTrabajador Visual) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.Visual = Visual;
        this.Visual.BTNingresar.addActionListener((ActionListener) this);
    }

     public void iniciar() {
        Visual.setTitle("Log In");
        Visual.setLocationRelativeTo(null); //Formulario en el centro
        Visual.txtClave.setVisible(false);  //campo id invisible

    }
     
     public void limpiar() {
        Visual.txtClave.setText(null);
        Visual.txtUsuario.setText(null);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Visual.BTNingresar) {
            try {
                modelo.setUsuario(Visual.txtUsuario.getText());
                if (consultas.buscar(modelo)) {
                    if (modelo.getPassword().equals(Visual.txtClave.getText())) {
                        System.out.println("llegue");
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "No se encuentra Registro");
                }
            } catch (Exception error) {
            }
        }
    }
}

