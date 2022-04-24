package Citas;

import administradorServlet.data.ConexionMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Citas {
    private double id;
    private double medicoId;
    private double paciId;
    private String hora;
    private String dia;
    private String especialidad;
    private String lugar;
    private String fecha;

    public Citas(double id, double medicoId, double paciId, String hora, String dia, String especialidad, String lugar, String fecha) {
        this.id = id;
        this.medicoId = medicoId;
        this.paciId = paciId;
        this.hora = hora;
        this.dia = dia;
        this.especialidad = especialidad;
        this.lugar = lugar;
        this.fecha = fecha;
    }
    public Citas() {

    }
    

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(double medicoId) {
        this.medicoId = medicoId;
    }

    public double getPaciId() {
        return paciId;
    }

    public void setPaciId(double paciId) {
        this.paciId = paciId;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    @Override
    public String toString() {
        return "Citas{" + "id=" + id + ", medicoId=" + medicoId + ", paciId=" + paciId + ", hora=" + hora + ", dia=" + dia + ", especialidad=" + especialidad + ", lugar=" + lugar + '}';
    }

    public void insertCita(Citas cita){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO Citas(id, medicoId, paciId, hora, dia, especialidad, ciudad, fecha, estado) values ("+cita.getId()+", "+cita.getMedicoId()+", "+cita.getPaciId()+","
                    + " '"+cita.getHora()+"', '"+cita.getDia()+"', '"+cita.getEspecialidad()+"', '"+cita.getLugar()+"', '"+cita.getFecha()+"', 'Pendiente')");

            con.close();
        }catch (SQLException e) {
        e.getSQLState();
        }
    }
    
}


