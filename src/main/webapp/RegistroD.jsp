<%-- 
    Document   : RegistroD
    Created on : 10 abr 2022, 18:51:23
    Author     : karom
--%>
  
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
                <tr ><td>Ingrese id: </td><td> <input type="text" name="id" class="form_input">
                     </div><br><br><br>
                     
                          
                               <div class="form_section">
                 <tr ><td>Ingrese clave: </td><td><input type="text" name="clave" class="form_input" >
                               </div><br><br><br>
                               
                                 <div class="form_section">
                 <tr ><td>Confirmacion de clave: </td><td><input type="text" name="confirmacion" class="form_input" >
                               </div><br><br><br>
                               
                    <input type="submit" name="registrar" value="Registrar" class="form_input">
                    <a class="botom" href="/Proyecto1/index.html">Regresar</a>
                
                </ul>
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
