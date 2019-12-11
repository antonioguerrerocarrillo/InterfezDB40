/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazcrud;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.management.remote.JMXConnectorFactory.connect;


/**
 *
 * @author cuvil
 */
public class ConectarSQLITE_clientes{

    private ArrayList<Clientes> arrayClientes;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public ConectarSQLITE_clientes() {
        
        this.ruta = "C:\\Users\\cuvil\\Documents\\MiBaseDeDatos.db.sqbpro";
        this.url = "jdbc:sqlite:";
    
          try{
            this.con = (Connection) DriverManager.getConnection(this.url+this.ruta);   
                if(this.con== null){
                    con.close();
                }
            }catch (SQLException e){
                
                 System.out.println(""+e);
            }
    }

    public static Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void setArrayPersonal(ArrayList<Clientes> arrayClientes) {
        this.arrayClientes = arrayClientes;
    }
     public ArrayList<Clientes>  getArrayRegion() {
        return this.arrayClientes;
    }    
    public static int AddConsultaClientes(String dni,String nombre,String apellidos,int telefono)throws SQLException{
        int ids = 0;
        
        String query = "INSERT INTO Clientes (dni,nombre,apellidos,telefono) VALUES (?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
        ps.setString(1, dni);
        ps.setString(2, nombre);
        ps.setString(3, apellidos);
        ps.setInt(4, telefono);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            ids=rs.getInt(1);
        }
        
        return ids;

        }
    public static void deleteClientes(Clientes r) throws SQLException{
        
       // try{
//            String query = "DELETE FROM Clientes WHERE dni = ?";
  //          PreparedStatement ps = con.prepareStatement(query);
    //        ps.setString(1, r.getDni());
     //       ps.executeUpdate();
       // }catch(SQLException e){}
 
    }
    public static void get_ClientesSistema(ArrayList<Clientes> arrayClientes,ConectarSQLITE_clientes r) throws SQLException{
  
    Statement stmt = null;
    String dni;
    String nombre = null;
    String apellido = null;
    int telefono = 0;
   
    
    String query = "select * from Clientes";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     Clientes u = new Clientes();

                     dni = rs.getString("Dni");
                     u.setDni(dni);
                     
                     nombre = rs.getString("Nombre");
                     u.setNombre(nombre);
                     
                     apellido = rs.getString("Apellidos");
                     u.setApellido(apellido);

                     telefono = rs.getInt("Telefono");
                     u.setTelefono(telefono);

                
                    arrayClientes.add(u);
                }
             }catch(SQLException e ) {}
        
    }
    
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<Clientes> arrayClientes){
      
             ConectarSQLITE_clientes r = new ConectarSQLITE_clientes();
            
             try{
                ConectarSQLITE_clientes.get_ClientesSistema(arrayClientes,r);
            }catch(SQLException e){}
      }

    int AddConsultaClientes(String dni, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}