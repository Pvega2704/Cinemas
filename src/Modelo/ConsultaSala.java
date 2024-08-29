
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultaSala extends Conexion {

 public boolean buscar(sala sal) {

        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con = getConexion();
// Porbar si este muestra el id siendo el ticket o usamos la variable ticket 
        String sql = "SELECT * FROM sala WHERE Pelicula=?"; 
        // Ojo esta parte  DE  Busqueda
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sal.getPelicula());
            rs=ps.executeQuery();
            
            if(rs.next()){
            sal.setNumeroSala(Integer.parseInt(rs.getString("Numero de Sala")));
            sal.setEspaciosDisponibles(Integer.parseInt(rs.getString("EspaciosDisponibles")));
            sal.setEspaciosOcupados(Integer.parseInt(rs.getString("EspaciosOcupados")));
            sal.setPelicula(rs.getString("Pelicula"));
            
             
                      return true;
                
            }
            return false;
            } catch (SQLException e) {
            System.err.print(e);
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

