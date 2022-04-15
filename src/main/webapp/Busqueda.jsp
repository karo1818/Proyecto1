<%-- 
    Document   : Busqueda
    Created on : 13 abr 2022, 20:00:44
    Author     : karom
--%>

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
        
        
        <div class="segundo">
           <label for="cars">Elija una especialidad</label>

                <select>
                  <option value="1">Dermatologia</option>
                  <option value="2">Cardiologia</option>
                  <option value="3">Psicologia</option>
                  <option value="4">Pediatria</option>
                  <option value="5">Oncologia</option>
                </select> 
           
           &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <label for="cars">Elija una provincia:</label>
            
                 <select >
                  <option value="6">Alajuela</option>
                  <option value="7">San Jose</option>
                  <option value="8">Cartago</option>
                  <option value="9">Heredia</option>
                  <option value="10">Limon</option>
                  <option value="11">Guanacaste</option>
                  <option value="12">Puntarenas</option>
                </select> 
            
             &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
            
            <input type="button" value="Buscar" class="form_input2"  width="100" height="256" >
            
            
           
            
            <div class="cuadro">
            
           <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br><br><br> <br>
            
            </div>
            
        </div>
    
    
        
    
        
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
        </body>
    
</html>
