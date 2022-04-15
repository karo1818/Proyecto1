package pacienteServlet.logic;

import administradorServlet.data.ConexionMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Citas {
    private double id;
    private String medicoId;
    private String paciId;
    private String hora;
    private String dia;
    private String especialidad;
    private String lugar;

    public Citas(double id, String medicoId, String paciId, String hora, String dia, String especialidad, String lugar) {
        this.id = id;
        this.medicoId = medicoId;
        this.paciId = paciId;
        this.hora = hora;
        this.dia = dia;
        this.especialidad = especialidad;
        this.lugar = lugar;
    }
    public Citas() {

    }
    

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(String medicoId) {
        this.medicoId = medicoId;
    }

    public String getPaciId() {
        return paciId;
    }

    public void setPaciId(String paciId) {
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

    @Override
    public String toString() {
        return "Citas{" + "id=" + id + ", medicoId=" + medicoId + ", paciId=" + paciId + ", hora=" + hora + ", dia=" + dia + ", especialidad=" + especialidad + ", lugar=" + lugar + '}';
    }

    public void insertCita(Citas cita){
        Connection con = null;
        try{
            con = ConexionMySQL.ConectarBasedeDatos1();
            Statement statement = con.createStatement();

            statement.executeUpdate("INSERT INTO Citas(id, medicoId, paciId, hora, dia, especialidad, lugar) values ("+cita.getId()+", "+cita.getMedicoId()+", "+cita.getPaciId()+","
                    + " '"+cita.getHora()+"', '"+cita.getDia()+"', '"+cita.getEspecialidad()+"', '"+cita.getLugar()+"')");

            con.close();
        }catch (SQLException e) {
        e.getSQLState();
        }
    }
    
}
