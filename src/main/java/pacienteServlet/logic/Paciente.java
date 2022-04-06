/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacienteServlet.logic;
import administradorServlet.data.ConexionMySQL;
import static java.lang.System.out;
import pacienteServlet.logic.Citas;

import java.util.List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author karom
 */
public class Paciente {
      private double ID;
      private String clave;
      private double ingreso;
      private String nombre;
      List <Citas> citasPac;

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
    
    public String getNombre(){
        return nombre;
    }
    public Paciente(double i, String c, double in) {
        
        ID= i;
        clave= c;
        ingreso=in;
    }
    
    public Paciente(double i, String c, String n, double in) {
        
        ID= i;
        clave= c;
        nombre=n;
        ingreso=in;
    }
    
    public Paciente() {
    }

    @Override
    public String toString() {
        return "Paciente{" + "ID=" + ID + ", clave=" + clave + ", ingreso=" + ingreso + ", nombre=" + nombre + '}';
    }

    
    
    public boolean busqPaciente(double id2, String clave2){
        Connection con = null;
        Paciente paciente = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Pacientes WHERE Pacientes.id = "+id2+" and Pacientes.clave= '"+clave2+"'");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                paciente = new Paciente(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"), 2);
            }
            con.close();
            return paciente != null;
        } catch (SQLException e) {
            return false;
        }
        
    }
    
    
    public ArrayList<Paciente> pacientesBD(){

        ArrayList<Paciente> per = new ArrayList();

        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Pacientes");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Paciente cue;
                cue = new Paciente(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"), rs.getDouble("ingreso"));
                per.add(cue);

            }

            con.close();
        } catch (SQLException e) {
        }
        return per;
    }
    
    

    
  
}
