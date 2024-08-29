package Modelo;

import java.sql.*;

import Modelo.Conexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaTicket extends Conexion {

    //GUARDADO
    public boolean registrar(ticket tik) {
        //con el extends ya hacemos lo de herencia y registrar es el ingreso de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO ticket (Cedula,Nombre,Correo,Precio,IVA,PrecioTotal,CantidadEntradas,Pelicula) VALUES (?,?,?,?,?,?,?,?)";
        // Ojo esta parte es de la insercion
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tik.getCedula());
            ps.setString(2, tik.getNombre());
            ps.setString(3, tik.getCorreo());
            ps.setInt(4, 3000);
            ps.setDouble(5, 0.13); // IVA
            ps.setInt(6, (int) ((3000 * 0.13) * tik.getCantidadEntradas() + (3000 * tik.getCantidadEntradas()))); // hacerlo en el controlador
            ps.setInt(7, tik.getCantidadEntradas());
            ps.setString(8, tik.getPelicula());

//Modificar esto
            ps.execute();
            return true;
            
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

    public boolean buscar(ticket tik) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
// Porbar si este muestra el id siendo el ticket o usamos la variable ticket 
        String sql = "SELECT * FROM ticket WHERE Cedula=?";
        // Ojo esta parte  DE  Busqueda
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tik.getNumeroTicket());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tik.setNumeroTicket(Integer.parseInt(rs.getString("NumeroTicket")));
                tik.setCedula(Integer.parseInt(rs.getString("Cedula")));
                tik.setNombre(rs.getString("Nombre"));
                tik.setCorreo(rs.getString("Correo"));
                tik.setPrecio(Integer.parseInt(rs.getString("Precio")));
                tik.setIVA(Double.parseDouble(rs.getString("IVA")));
                tik.setPrecioTotal(Integer.parseInt(rs.getString("PrecioTotal")));
                tik.setCantidadEntradas(Integer.parseInt(rs.getString("CantidadEntradas")));
                tik.setPelicula(rs.getString("Pelicula"));
                
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
  public ArrayList<ticket> todostickets() {
        ArrayList<ticket> miListaTicket = new ArrayList<>();
        
          PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
// Porbar si este muestra el id siendo el ticket o usamos la variable ticket 
        String sql = "SELECT * FROM ticket";
        try {
         
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
    
            while (rs.next()) {
              ticket tik = new ticket(rs.getInt("NumeroTicket"), rs.getInt("Cedula"), rs.getString("Nombre"), rs.getString("Correo"),
                        rs.getInt("Precio"), rs.getDouble("IVA"), rs.getInt("PrecioTotal"), rs.getInt("CantidadEntradas"), rs.getString("Pelicula"));
                miListaTicket.add(tik);
            }
            rs.close();
           
        } catch (SQLException e) {
            Logger.getLogger(ConsultaTicket.class.getName()).log(Level.SEVERE, null, e);
        }
        return miListaTicket;
    }
  
  
  
  
  
  
    public ArrayList<ticket> informacionTicket(int Cedula) { //buesqueda
        ArrayList<ticket> miListaTicket = new ArrayList<>();
        try {
            // Crear la conexiÃ³n con la BD
            Conexion con = new Conexion();
            PreparedStatement st = con.crearPrepareStatement("SELECT * FROM ticket WHERE cedula LIKE ?");
            Cedula = '%' + Cedula + '%';
            st.setInt(1, Cedula);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ticket tik = new ticket(rs.getInt("NumeroTicket"), rs.getInt("Cedula"), rs.getString("Nombre"), rs.getString("Correo"),
                        rs.getInt("Precio"), rs.getDouble("IVA"), rs.getInt("PrecioTotal"), rs.getInt("CantidadEntradas"), rs.getString("Pelicula"));
                miListaTicket.add(tik);
            }
            rs.close();
            con.closeConexion();
        } catch (SQLException e) {
            // Manejar la excepciÃ³n de alguna manera, como mostrar un mensaje de error
            e.printStackTrace(); // Para ver la traza de la excepciÃ³n en la consola
            // TambiÃ©n puedes registrarla en un logger si es necesario
        }
        return miListaTicket;
    }    
    
}
