<%-- 
    Document   : IngresoPaci
    Created on : 31 mar 2022, 21:12:48
    Author     : karom
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <form method="POST" name="paciente" action="paciente/registrar">
           <link href="../css/IngrePaci.css" rel="stylesheet" type="text/css">
    </head>
     

    
        <div class="header">
           
            <img class="avatar" src="../images/perfil.png" width="256" height="256">  
            

            <h1 class="user-name"><%=p.getNombre()%>
              
                </h1>
                    
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
             <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

              </ul>
            
            
        </div>
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    
</html>
