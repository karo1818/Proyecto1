<%-- 
    Document   : IngresoMedi
    Created on : 31 mar 2022, 21:12:14
    Author     : karom
--%>
<%@page import="administradorServlet.logic.Medico"%>
<%
    Medico m  = (Medico) request.getAttribute("medico");
  
 %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Medico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
         <link href="../css/IngreMedi.css" rel="stylesheet" type="text/css">
    </head>
   <body background="../images/fondo.jpg">
       
        
        <div class="header">
            
            <img class="avatar" src="../images/perfil.png" width="256" height="256">
            <h1 class="user-name" >MEDICO</h1>
            </div>
        
        
        <div class="segundo">
            <ul class="social">
                
               
                   
                
                </ul>
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
