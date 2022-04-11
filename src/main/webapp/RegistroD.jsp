<%-- 
    Document   : RegistroD
    Created on : 10 abr 2022, 18:51:23
    Author     : karom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>MI PERFIL</title>
        <link href="../css/IngreMedi.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body background="../images/fondo.jpg">
       
        
        <div class="header">
            
            <img class="avatar" src="../images/perfil.png" width="256" height="256">
            <h1 class="user-name"> </h1>
                       
            </div>
        
        
        <div class="segundo">
            <ul class="social">
               
                    <input type="text" name="especialidad" class="form_input" placeholder="Especialidad a buscar">
                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="text" name="localidad" class="form_input" placeholder="Localidad a buscar">
                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <input class="botom" type="submit" name="buscar" value="Buscar" class="form_input">
                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;                     
                    <a class="botom" href="/Proyecto1/index.html">Regresar</a>
                
                </ul>
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
