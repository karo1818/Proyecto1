<%-- 
    Document   : RegistroD
    Created on : 10 abr 2022, 18:51:23
    Author     : karom
--%>
  
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Registro paciente</title>
        <link href="css/RegistroP.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body background="images/fondo.jpg">
        
         <form method="POST" name="medico" action="medico/registrar">
          
        
        <div class="header">
            
           
            <h1 class="user-name"> REGISTRO MEDICO </h1>
                       
            </div>
        
        
         <div class="segundo">
            <ul class="social">
                  <div class="form_section">                      
                  
                <tr ><td>Ingrese su foto de perfil: </td><td><input type="file" name="imagen" accept="image/jpg, image/gif, image/png">
                </div><br><br><br>
                
                <div class="form_section">
                <tr ><td>Ingrese id: </td><td> <input type="text" name="id" class="form_input">
                </div><br><br><br>
                     
                          
                <div class="form_section">
                <tr ><td>Ingrese clave: </td><td><input type="text" name="clave" class="form_input" >
                </div><br><br><br>
                               
                <div class="form_section">
                <tr ><td>Confirmacion de clave: </td><td><input type="text" name="confirmacion" class="form_input" >
                </div><br><br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su nombre:</td><td> <input type="text" name="nombre" class="form_input">
                </div><br><br> 
                
                <div class="form_section">  
                <label for="cars">Elija una especialidad</label>
                    <%Connection con = null;%>
                    <%try {%>
                        <%con = ConexionMySQL.ConectarBasedeDatos1();%>
                        <%CallableStatement statement = con.prepareCall("SELECT * FROM Especi");%>
                        <%ResultSet rs = statement.executeQuery();%>
                        <select name="especialidad">
                        <%while(rs.next()){ %> 
                            <option><%= rs.getString(1)%></option>
                            <%} %>     
                        </select> 
                        <%con.close();%>
                    <%} catch (Exception e) {%>
                        <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);%>
                    <%}%>
                </div><br><br>
                
                <div class="form_section">  
                <label for="cars">Elija una ciudad</label>  
                    <%try {%>
                        <%con = ConexionMySQL.ConectarBasedeDatos1();%>
                        <%CallableStatement statement = con.prepareCall("SELECT * FROM Ciudades");%>
                        <%ResultSet rs = statement.executeQuery();%>
                        <select name="ciudad">
                        <%while(rs.next()){ %> 
                            <option><%= rs.getString(1)%></option>
                            <%} %>     
                        </select> 
                        <%con.close();%>
                    <%} catch (Exception e) {%>
                        <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);%>
                    <%}%>
                </div><br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su horario</td><td> <input type="text" name="horario" class="form_input">
                </div><br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su frecuenciaCitas</td><td> <input type="text" name="frecuenciaCitas" class="form_input">
                </div><br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su costo</td><td> <input type="text" name="costo" class="form_input">
                </div><br>   
                <br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su hora de atencion inicial</td><td> <input type="text" name="horaInicio" class="form_input">
                </div><br>   
                <br><br>
                
                <div class="form_section">  
                <tr ><td>Ingrese su hora de atencion final</td><td> <input type="text" name="horaFinal" class="form_input">
                </div><br>   
                <br><br>
                               
                <input type="submit" name="registrar" value="Registrar" class="form_input">
                <a class="botom" href="/Proyecto1/index.html">Regresar</a>
                
                </ul>
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       </form>
    </body>
</html>
