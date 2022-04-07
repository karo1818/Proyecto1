/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;

import administradorServlet.data.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pacienteServlet.logic.Paciente;

/**
 *
 * @author karom
 */
public class Administrador {

      private double ID;
      private String clave;
      private double ingreso;

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }
    
    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
  
 
 
    

    public Administrador(double i, String c, double in) {
        
        ID= i;
        clave= c;
        ingreso= in;
    }
    
    public Administrador() {
    }


    
     public boolean busqAdmi(double id2, String clave2){
        Connection con = null;
        Administrador administrador = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Admi WHERE id = "+id2+" and clave= '"+clave2+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                administrador = new Administrador(rs.getDouble("id"), rs.getString("clave"), 1);
            }
            con.close();
            return administrador != null;
        } catch (Exception e) {
            return false;
        }
        
    }
     
     
      public ArrayList<Administrador> administradorBD(){

        ArrayList<Administrador> admi = new ArrayList();

        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Admi");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Administrador administrador;
                administrador = new Administrador(rs.getDouble("id"), rs.getString("clave"), rs.getDouble("ingreso"));
                admi.add(administrador);

            }

            con.close();
        } catch (SQLException e) {
        }
        return admi;
    }
 
    
   
    
}
