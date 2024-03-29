/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacienteServlet.logic;
import administradorServlet.data.ConexionMySQL;
import Citas.Citas;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private String confirmacion;
    String codigo;

    public Paciente(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Paciente(double ID, String clave, String nombre, String confirmacion) {
        this.ID = ID;
        this.clave = clave;
        this.nombre = nombre;
        this.confirmacion = confirmacion;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
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
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void citasList(Paciente paci){
        Connection con = null;
        citasPac = new ArrayList<>();
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Citas WHERE paciId = "+paci.getID());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Citas cita;
                cita = new Citas(rs.getDouble("id"), rs.getDouble("medicoId"), rs.getDouble("paciId"), rs.getString("hora"),
                rs.getString("dia"), rs.getString("especialidad"), rs.getString("lugar"), rs.getString("fecha"));
                citasPac.add(cita);
            }
            con.close();
        } catch (SQLException e) {

        }
    }

}
