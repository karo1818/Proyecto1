/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicoServlet.logic;

import administradorServlet.data.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author karom
 */
public class Medico {
 
      private double ID;
      private String clave;
      private double ingreso;
      private String nombre;
      

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

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
  
 
 
    

    public Medico(double i, String c, double in) {
        
        ID= i;
        clave= c;
        ingreso= in;
    }
    
     public Medico(double i, String c, String n, double in) {
        
        ID= i;
        clave= c;
        nombre=n;
        ingreso=in;
    }
    
    
    public Medico() {
        
    }


    public boolean busqMedico(double id2, String clave2){
        Connection con = null;
        Medico medicos = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medico WHERE Medico.id = "+id2+" and Medico.clave= '"+clave2+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                medicos = new Medico(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"), 3);
            }
            con.close();
            return medicos != null;
        } catch (SQLException e) {
            return false;
        }
        
    }
    
    
    public ArrayList<Medico> medicosBD(){

        ArrayList<Medico> med = new ArrayList();

        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medico");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Medico medi;
                medi = new Medico(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"), rs.getDouble("ingreso"));
                med.add(medi);

            }

            con.close();
        } catch (SQLException e) {
        }
        return med;
    }
    
 
    
    
    
    
}
