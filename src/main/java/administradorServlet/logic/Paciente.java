/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;

import administradorServlet.data.ConexionMySQL;

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
    
    public Paciente(double i, String c, String n) {
        
        ID= i;
        clave= c;
        nombre=n;
    }
    
    public Paciente() {
    }
    
    public List<Paciente> pacientesBD(Paciente p){
    
        List<Paciente> per = new ArrayList();

        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos();
            CallableStatement statement = con.prepareCall("select * from Pacientes");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Paciente cue;
                cue = new Paciente(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"));
                per.add(cue);

            }

            con.close();
        } catch (SQLException e) {
        }
        return per;
    }
  
}
