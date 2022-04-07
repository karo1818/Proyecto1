<%-- 
    Document   : IngresoPaci
    Created on : 31 mar 2022, 21:12:48
    Author     : karom
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%
    Paciente p  = (Paciente) request.getAttribute("paciente");
    DecimalFormat df = new DecimalFormat("####,###");
 %>
<!DOCTYPE html>
<html>
    <head>
        <title>MI PERFIL</title>
        <link href="../css/IngrePaci.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body background="../images/fondo.jpg">
       
        
        <div class="header">
            
            <img class="avatar" src="../images/perfil.png" width="256" height="256">
            <h1 class="user-name"> <%=p.getNombre()%></h1>
                       
            </div>
        
        
        <div class="segundo">
            <ul class="social">
               
                    <input type="text" name="especialidad" class="form_input" placeholder="Especialidad a buscar">
                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="text" name="localidad" class="form_input" placeholder="Localidad a buscar">
                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <input class="botom" type="submit" name="buscar" value="Buscar" class="form_input">
                 
                
                </ul>
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
