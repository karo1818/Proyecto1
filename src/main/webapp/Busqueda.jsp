<%-- 
    Document   : Busqueda
    Created on : 13 abr 2022, 20:00:44
    Author     : karom
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%
    
 %>
 
<!DOCTYPE html>

<html>
    
    <head>
        <title>MI PERFIL</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
           <link href="/Proyecto1/css/IngrePaci.css" rel="stylesheet" type="text/css">
    </head>
     

    
        <div class="header">
           
            <img class="avatar" src="/Proyecto1/images/desconocido.png" width="256" height="256">  
            

            <h1 class="user-name">SIN REGISTRO</h1>
                    
            </div>
        
        <form method="post" name="form" action="/Proyecto1/pacienteServlet/presentation/ciudades"> 
        <div class="segundo">
         <label for="cars">Elija una especialidad</label>

        <%Connection con = null;%>
        <%try {%>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT * FROM Especi");%>
            <%ResultSet rs = statement.executeQuery();%>
            <%int cont=1;%>
            <select name="especi">
            <%while(rs.next()){ %> 
                <option value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>

                <%cont++;%>
                <%} %>     
            </select> 
            <%con.close();%>
        <%} catch (Exception e) {%>
            <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);%>
        <%}%> 
      
           &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <label for="cars">Elija una ciudad:</label>
            
               <%try {%>
                <%con = ConexionMySQL.ConectarBasedeDatos1();%>
                <%CallableStatement statement = con.prepareCall("SELECT * FROM Ciudades");%>
                <%ResultSet rs = statement.executeQuery();%>
                <%int cont=1;%>
                <select name="ciudad" >
                <%while(rs.next()){ %> 
                    <option name="ciudad" value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>

                    <%cont++;%>
                    <%} %>     
                </select> 
                <%con.close();%>
            <%} catch (Exception e) {%>
                <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);%>
            <%}%>
            
            
             &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <input type="submit" name="ciudades" value="Buscar" class="form_input2"  width="100" height="256" >
             <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

              </ul>

        </div>
            
        </form>    
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
      
       

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    
    <head>
        <title>Busqueda</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <form method="POST" name="paciente" action="paciente/registrar">
           <link href="css/RegistroP.css" rel="stylesheet" type="text/css">
    </head>
     
<body background="images/fondo.jpg">
    
        <div class="header">
           
            
            
            <img class="avatar1" src="images/desconocido.png" width="250" height="250">
            <h1 class="user-name1">SIN REGISTRO </h1>
                    
            </div>
        
        <div class="cuadro">
        
           <label>Elija una especialidad</label>
           
        <%Connection con = null;%>
        <%try {%>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT * FROM Especi");%>
            <%ResultSet rs = statement.executeQuery();%>
            <%int cont=1;%>
            <select>
            <%while(rs.next()){ %> 
                <option value=cont><%= rs.getString(1)%></option>

                <%cont++;%>
                <%} %>     
            </select> 
            <%con.close();%>
        <%} catch (Exception e) {%>
            <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);%>
        <%}%>


           
           &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <label>Elija una ciudad</label>           

            <%try {%>
                <%con = ConexionMySQL.ConectarBasedeDatos1();%>
                <%CallableStatement statement = con.prepareCall("SELECT * FROM Ciudades");%>
                <%ResultSet rs = statement.executeQuery();%>
                <%int cont=1;%>
                <select>
                <%while(rs.next()){ %> 
                    <option value=cont><%= rs.getString(1)%></option>

                    <%cont++;%>
                    <%} %>     
                </select> 
                <%con.close();%>
            <%} catch (Exception e) {%>
                <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);%>
            <%}%>

             &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
            
            <input type="button" value="Buscar" class="form_input2"  width="100" height="256" >
            <br><br><br><br><br>
            
             <div class="div_citas">
                  <br>
                  <table class="citas">
                          <tr>
                            <th>Nombre</th>
                            <th>Ciudad</th>
                            <th>Horario</th>
                            <th>Costo</th>
                            <th>Frecuencia de citas</th>
                            <th>Especialidad</th>
                          </tr>
                          <tr>
                            <td>Karo</td>
                            <td> Moravia</td>
                            <td>viernes</td>
                            <td>1000</td>
                            <td> 10</td>
                            <td>Odontologia</td>
                          </tr>
                          <tr>
                            <td>Raquel</td>
                            <td> Moravia</td>
                            <td>viernes</td>
                            <td>1000</td>
                            <td> 10</td>
                            <td>Odontologia</td>
                          </tr>
                          <tr>
                            <td>Gabriel</td>
                           <td> Moravia</td>
                            <td>viernes</td>
                            <td>1000</td>
                            <td> 10</td>
                            <td>Odontologia</td>
                          </tr>
                           <tr>
                            <td>Jose</td>
                            <td> Moravia</td>
                            <td>viernes</td>
                            <td>1000</td>
                            <td> 10</td>
                            <td>Odontologia</td>
                          </tr>
                          
                           <tr>
                            <td>Camila</td>
                            <td> Moravia</td>
                            <td>viernes</td>
                            <td>1000</td>
                            <td> 10</td>
                            <td>Odontologia</td>
                          </tr>
                        </table>
                  <br>
                   
                  </div>
             
           
            
            
            
           <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br>
            
            </div>
            
        
    
    
        
    
        
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
        </body>
    
</html>
