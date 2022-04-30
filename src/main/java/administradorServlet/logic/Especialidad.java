/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;



import administradorServlet.data.ConexionMySQL;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
*
* @author Usuario
*/
public class Especialidad {



private String nombre;



public Especialidad() {
}



public Especialidad(String nombre) {
this.nombre = nombre;
}



public String getNombre() {
return nombre;
}



public void setNombre(String nombre) {
this.nombre = nombre;
}

public void insertEsp(Especialidad nuevaE){
Connection con = null;
try {
con = ConexionMySQL.ConectarBasedeDatos1();
Statement statement = con.createStatement();
statement.executeUpdate("INSERT INTO Especi(nombre) values ('"+nuevaE.getNombre()+"')");
con.close();
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);
}
}

}