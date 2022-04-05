package administradorServlet.data;
import javax.swing.*;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL {
    private static ConexionMySQL instance;
    public static Connection conexion;
    public static Statement sentencia;
    public ResultSet resultado;


    public ConexionMySQL() {
        
    }



    public static Connection ConectarBasedeDatos() throws InstantiationException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String server = "localhost";
            String port = "1433";//1433
            String database = "ProyectoCitasMedicas";
            String user = "sa";
            String password = "password";
            System.out.println("HOLIS");
            String url_bd = "jdbc:mysql://"+server+":"+port+"/"+database+"?user="+user+"&password="+
                    password+"&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            System.out.println(url_bd);
            conexion = DriverManager.getConnection(url_bd);
            System.out.println("HOLIS2");
            sentencia = conexion.createStatement();
            System.out.println("HOLIS3");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
System.out.println(conexion);
        return conexion;

    }
    
    

    public ResultSet ejecutableSQL(String sql){  //Info que se va a traer
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public int actualizar(String SQL) throws SQLException {
        return sentencia.executeUpdate(SQL);
    }
    
    public int cedula(String SQL) throws SQLException{
        Statement stmt = conexion.createStatement();
        ResultSet rs;
        String ID = "";

        rs = stmt.executeQuery(SQL);
        while ( rs.next() ) {
            String lastName = rs.getString("CEDULA");
            ID = lastName;
        }

        return Integer.parseInt(ID);
    }

    public void insertar(String SQL) throws SQLException {
        sentencia.executeUpdate(SQL);
    }
    
    

}
