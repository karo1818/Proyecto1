/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.data;

import administradorServlet.logic.Administrador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import medicoServlet.logic.Medico;
import pacienteServlet.logic.Paciente;

/**
 *
 * @author gabri
 */
public class ConexionBD {

    public ConexionBD() {
    }
    
    /*----------------------Medicos----------------------*/
    
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
        
            statement.executeUpdate("INSERT INTO Medico(id, clave, nombre,especialidad, ciudad, horario, frecuenciaCitas, costo, horaInicio, horaFin)"
             + " values ("+medi.getID()+", '"+medi.getClave()+"','"+medi.getNombre()+"', '"+medi.getEspecialidad()+"',"
                     + " '"+medi.getCiudad()+"', '"+medi.getHorario() +"', "+medi.getFreqCitas() +","+medi.getCosto()+",'"+medi.getHoraInicio()+"','"+medi.getHoraFin()+"')");
            
            
            
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    public Medico busqMedicoId(double id2){
        Connection con = null;
        Medico medico = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medico WHERE Medico.id = "+id2);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                medico = new Medico(rs.getDouble("id"), rs.getString("clave"), 3, rs.getString("nombre"), rs.getString("especialidad"), rs.getString("ciudad"), rs.getString("horario"), rs.getInt("frecuenciaCitas"), rs.getDouble("costo"), rs.getString("horaInicio"), rs.getString("horaFin"));
            }
            con.close();
            return medico;
        } catch (SQLException e) {
            return null;
        }

    }
    
    public ArrayList<Medico> medicosBD(String especi, String ciudad){
        ArrayList<Medico> medicos = new ArrayList();
        Connection con = null;
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Medico WHERE ciudad='"+ciudad+"' and especialidad='"+especi+"'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Medico medico;
                medico = new Medico(rs.getDouble("id"), rs.getString("clave"), 3, rs.getString("nombre"), rs.getString("especialidad"), rs.getString("ciudad"), rs.getString("horario"), rs.getInt("frecuenciaCitas"), rs.getDouble("costo"), rs.getString("horaInicio"), rs.getString("horaFin"));
                medicos.add(medico);
            }
            con.close();
        } catch (SQLException e) {
            
        }
        return medicos;
   }
    
    /*----------------------Pacientes----------------------*/
    
    public Paciente busqPacientePTR(double id2, String clave2){
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
            return paciente;
        } catch (SQLException e) {
            return null;
       }
        
    }
 
    public void insertPac(Paciente paci){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
        
            statement.executeUpdate("INSERT INTO Pacientes(id, clave, nombre) values ("+paci.getID()+", '"+paci.getClave()+"', '"+paci.getNombre()+"')");
            
            con.close();
        }catch (SQLException e) {
            e.getSQLState();
        }
    }
    
    /*----------------------Administrador----------------------*/
    
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
    
}
