/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




package administradorServlet.logic;



import administradorServlet.data.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
*
* @author Usuario
*/
public class Ciudad {



private String nombre;



public String getNombre() {
return nombre;
}



public void setNombre(String nombre) {
this.nombre = nombre;
}



public Ciudad() {
}



public Ciudad(String nombre) {
this.nombre = nombre;
}

public void insertCiud(Ciudad nuevaC){
Connection con = null;
try {
con = ConexionMySQL.ConectarBasedeDatos1();
Statement statement = con.createStatement();
statement.executeUpdate("INSERT INTO Ciudades(nombre) values ('"+nuevaC.getNombre()+"')");
con.close();
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);
}
}

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}