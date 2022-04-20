
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Administrador a  = (Administrador) request.getAttribute("administrador");
  
 %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Administrador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
         <link href="/Proyecto1/css/IngreAdmi.css" rel="stylesheet" type="text/css">
    </head >
    <body  background="/Proyecto1/images/fondo.jpg">
       
       
         
         <header  class="header" >
          
         
           <h1>PAGINA DEL ADMINISTRADOR</h1
            
             
             </header>
        
       
        <div class="LOGIN">
            
         <h2 class="listas" > LISTAS DISPONIBLES<br><br><br><br><br>
         <a href="/Proyecto1/listadoCiud.jsp">Ciudades</a> <br><br><br>
         <a href="/Proyecto1/listadoEsp.jsp">Especialidades</a> <br><br><br>
         <a href="/Proyecto1/listadoMed.jsp">Medicos</a> <br><br><br>
         <a class="botom" href="/Proyecto1/index.html">Regresar</a></a> <br><br><br>
         
          </h2>
            <br>
             
            </div>
           
            
            <br><br>
           
        
        <br> <br>
        
        <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
