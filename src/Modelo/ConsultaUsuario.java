package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bunoc
 */
public class ConsultaUsuario extends Conexion {

    public boolean buscar(usuario ud) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
// Porbar si este muestra el id siendo el ticket o usamos la variable ticket 
        String sql = "SELECT * FROM USUARIO WHERE Usuario=?";
        // Ojo esta parte  DE  Busqueda
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, ud.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                ud.setUsuario(rs.getString("usuario"));
                ud.setPassword(rs.getString("Password"));
                //return ud.getPassword();
                return true;
            }
            //return "not found";
            return false;
        } catch (SQLException e) {
            System.err.print(e);
            //return "not found";
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
 
   
    }
}
}

