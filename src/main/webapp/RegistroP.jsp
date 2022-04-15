<%-- 
    Document   : Registro
    Created on : 10 abr 2022, 17:55:59
    Author     : karom
--%>

<%@page import="pacienteServlet.logic.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Registro paciente</title>
        <link href="css/RegistroP.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body background="images/fondo.jpg">
         <form method="POST" name="paciente" action="paciente/registrar">
       
        
        <div class="header">
            
           
            <h1 class="user-name"> REGISTRO PACIENTE </h1>
                       
            </div>
        
        
        <div class="segundo">
            <ul class="social">
                
         
                <form method="POST" enctype="multipart/form-data" action="/cursos/add">
                    <div class="form_section">
                        
                  
                  <tr ><td>Ingrese su foto de perfil: </td><td><input type="file" name="imagen" accept="image/jpg, image/gif, image/png">
                </div><br><br><br>
                
                     <div class="form_section">
                <tr ><td>Ingrese id: </td><td> <input type="text" name="id" class="form_input">
                     </div><br><br><br>
                     
                     
                          <div class="form_section">
                 <tr ><td>Ingrese nombre: </td><td><input type="text" name="nombre" class="form_input" >
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
