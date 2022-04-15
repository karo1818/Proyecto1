/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicoServlet.logic;

import administradorServlet.data.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
      private String confirmacion;
       private int freqCitas;
      private double costo;
      private String ciudad;
      private String horario;
      


    public int getFreqCitas() {
        return freqCitas;
    }

    public void setFreqCitas(int freqCitas) {
        this.freqCitas = freqCitas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
      private String especialidad;

    public Medico(double ID, String clave, String confirmacion) {
        this.ID = ID;
        this.clave = clave;
        this.confirmacion = confirmacion;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

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
  
 
 
      public Medico(double ID, String clave, double ingreso, String nombre, String especialidad, String ciudad, String horario, int freqCitas, double costo) {
        this.ID = ID;
        this.clave = clave;
        this.ingreso = ingreso;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.horario = horario;
        this.freqCitas = freqCitas;
        this.costo = costo;
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
    
        @Override
    public String toString() {
        return "Medico{" + "ID=" + ID + ", clave=" + clave + ", ingreso=" + ingreso + ", nombre=" + nombre + ", especialidad=" + especialidad + ", ciudad=" + ciudad + ", horario=" + horario + ", freqCitas=" + freqCitas + ", costo=" + costo + '}';
    }
    
    

public Medico busqMedico(double id2, String clave2){
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
            return medicos;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    
 
    
    public void insertMed(Medico medi){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Medico(id, clave) values ("+medi.getID()+", '"+medi.getClave()+"')");
            
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    
        
    public void updateMed(Medico medi){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("UPDATE Medico SET especialidad = '"+medi.getEspecialidad()+"', ciudad = '"+medi.getCiudad()+"', "
                    + "horario = '"+medi.getHorario()+"', frecuenciaCitas = "+medi.getFreqCitas()+", costo = "+medi.getCosto()+" WHERE id = "+medi.getID());
            
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    


    
    
}
