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
            
            
           
            
            
            
           <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br>
            
            </div>
            
        
    
    
        
    
        
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
        </body>
    
</html>
