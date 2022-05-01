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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Citas.Citas;
import java.time.LocalTime;


/**
 *
 * @author karom
 */
public class Medico {    
    private String NB;
    private String EB;
    private String nombre;
    private double ID;
    private String clave;
    private double ingreso;
    private String confirmacion;
    private int freqCitas;
    private double costo;
    private String ciudad;
    private String horario;
    private String especialidad;
    List <Citas> citasPac;
    private String horaFin;
    private String horaInicio;

    public ArrayList<LocalTime> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<LocalTime> horas) {
        this.horas = horas;
    }
      ArrayList<LocalTime> horas;

    public String getNB() {
        return NB;
    }

    public void setNB(String NB) {
        this.NB = NB;
    }

    public String getEB() {
        return EB;
    }

    public void setEB(String EB) {
        this.EB = EB;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
     
    public int getFreqCitas() {
        return freqCitas;
    }

    public Medico(double ID, String clave, String nombre, String confirmacion, int freqCitas, double costo, String ciudad, String horario, String especialidad, String horaInicio, String horaFin) {
        this.ID = ID;
        this.clave = clave;
        this.nombre = nombre;
        this.confirmacion = confirmacion;
        this.freqCitas = freqCitas;
        this.costo = costo;
        this.ciudad = ciudad;
        this.horario = horario;
        this.especialidad = especialidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public List<Citas> getCitasPac() {
        return citasPac;
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
      

    public Medico(double ID, String clave, double ingreso, String nombre, String especialidad, String ciudad, String horario, int freqCitas, double costo, String horaInicio, String horaFin) {
        this.ID = ID;
        this.clave = clave;
        this.ingreso = ingreso;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.horario = horario;
        this.freqCitas = freqCitas;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        creacionDeLosHorarios();
    }
 
    public Medico(double i, String c, double in) { 
        ID= i;
        clave= c;
        ingreso= in;
    }
    
    
    public Medico(double i, String n ,String nb, String eb) {  
        ID= i;
        nombre= n;
        NB = nb;
        EB = eb; 
            
    }
    
    public Medico(String nb, String eb) {
        NB = nb;
        EB = eb;        
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
    
    
    public String toString2() {
        return "Medico{" + "ID=" + ID + ", clave=" + clave + ", ingreso=" + ingreso + ", nombre=" + nombre + ", especialidad=" + especialidad + ", ciudad=" + ciudad + ", horario=" + horario + ", freqCitas=" + freqCitas + ", costo=" + costo +", horaInicio="+horaInicio+", horaFin="+horaFin+'}' ;                      
    }        
    
    public void citasList(int id){
        Connection con = null;
        citasPac = new ArrayList<>();
        try {
            con = ConexionMySQL.ConectarBasedeDatos1();
            CallableStatement statement = con.prepareCall("SELECT * FROM Citas WHERE paciId = "+id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Citas cita;
                cita = new Citas(rs.getDouble("id"), rs.getDouble("medicoId"), rs.getDouble("paciId"), rs.getString("hora"),
                rs.getString("dia"), rs.getString("especialidad"), rs.getString("ciudad"), rs.getString("fecha"));
                citasPac.add(cita);
            }
            con.close();
        } catch (SQLException e) {

        }
    }
        

    
    void creacionDeLosHorarios(){
        horas = new ArrayList();
        LocalTime time = LocalTime.parse(horaInicio);
        int horaFinn = Integer.parseInt(horaFin.substring(0, 2));
        int freq = this.freqCitas;
        while(time.getHour() < horaFinn){
            horas.add(time);
            time = time.plusMinutes(freq);
        }
    }
        
}
