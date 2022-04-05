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
public class Pacientes2 {
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
    
    public Pacientes2(double i, String c, String n) {
        
        ID= i;
        clave= c;
        nombre=n;
    }
    
    public Pacientes2() {
    }

    @Override
    public String toString() {
        return "Pacientes2{" + "ID=" + ID + ", nombre=" + nombre + '}';
    }
    
    
    public ArrayList<Pacientes2> pacientesBD(){

        ArrayList<Pacientes2> per = new ArrayList();

        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Pacientes");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Pacientes2 cue;
                cue = new Pacientes2(rs.getDouble("id"), rs.getString("clave"), rs.getString("nombre"));
                per.add(cue);

            }

            con.close();
        } catch (SQLException e) {
        }
        return per;
    }
  
}
