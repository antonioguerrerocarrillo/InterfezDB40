/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cuvil
 */
public class ConectarSQLITE_personal{
          
    private ArrayList<Personal> arrayPersonal;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public ConectarSQLITE_personal() {
        
        this.ruta = "C:\\Users\\cuvil\\Documents\\MiBaseDeDatos.db";
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
    
    public void setArrayPersonal(ArrayList<Personal> arrayPersonal) {
        this.arrayPersonal = arrayPersonal;
    }
     public ArrayList<Personal>  getArrayRegion() {
        return this.arrayPersonal;
    }    
    public static int AddConsultaPersonal(String nombre,String apellidos,String departamento,int id)throws SQLException{
        int ids = 0;
        
        String query = "INSERT INTO Personal (nombre,apellidos,departamento,id) VALUES (?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setString(2, apellidos);
        ps.setString(3, departamento);
        ps.setInt(4, id);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            ids=rs.getInt(1);
        }
        
        return ids;

        }
    public static void deletePersonal(Personal r) throws SQLException{
        
        try{
            String query = "DELETE FROM Personal WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
        }catch(SQLException e){}
 
    }
    public static void get_PersonalSistema(ArrayList<Personal> arrayPersonal,ConectarSQLITE_personal r) throws SQLException{
  
    Statement stmt = null;
    String nombre = null;
    String apellido = null;
    String departamento = null;
    int id = 0;
   
    
    String query = "select * from Personal";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     Personal u = new Personal();

                     nombre = rs.getString("Nombre");
                     u.setNombre(nombre);
                     
                     apellido = rs.getString("Apellidos");
                     u.setApellido(apellido);
                     
                     
                     departamento = rs.getString("Departamento");
                     u.setDepartamento(departamento);

                     id = rs.getInt("Id");
                     u.setId(id);

                
                    arrayPersonal.add(u);
                }
             }catch(SQLException e ) {}
        
    }
    
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<Personal> arrayPersonal){
      
             ConectarSQLITE_personal r = new ConectarSQLITE_personal();
            
             try{
                ConectarSQLITE_personal.get_PersonalSistema(arrayPersonal,r);
            }catch(SQLException e){}
      }
            
}