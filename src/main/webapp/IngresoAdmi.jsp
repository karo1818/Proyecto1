
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Administrador a  = (Administrador) request.getAttribute("identificacion");
  
 %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Administrador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="./css/Principal.css" type="text/css">
    </head>
    <body background="images/fondo.jpg">
         <form method="POST" name="administrador" action="administrador/ingresar">
       
          <center>
         <header  class="header" >
          
         
           <h1>PAGINA DEL ADMINISTRADOR</h1
            
             
             </header>
        
       
        <div class="LOGIN">
            
          <h1> LISTAS </h1>

            <br>
             <div class="form_section">
                  <a href="">Ciudades</a> <br><br><br>
                </div>
          <br>
                    
            <div class="form_section">
                
                <a href="">Especialidades</a> <br><br><br>
                </div>
                    
          
            <br>
                <div class="form_section_buttom">
                       <a href="">Medicos</a> <br><br><br>
                        </div>
            
           
            
            <br><br>
           
        
        <br> <br>
        
        <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
         <center>
    </body>
</html>
