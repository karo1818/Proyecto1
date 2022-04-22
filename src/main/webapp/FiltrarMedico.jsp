<%-- 
    Document   : FiltrarMedico
    Created on : 21 abr 2022, 20:00:47
    Author     : karom
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="medicoServlet.logic.Medico"%>
<%
   Medico m  = (Medico) request.getAttribute("medico");


  Medico d = new Medico( 11,  "Manuel",  122,  "Manuel",  "Odontologia",  "Guatuso",  "Lunes",  10,  10);
    

%>
 

<!DOCTYPE html>
<html>
  
        
    <head>
        <title>Sistema Medico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
         <link href="/Proyecto1/css/IngreMedi.css" rel="stylesheet" type="text/css">
    </head>
        <body background="/Proyecto1/images/fondo.jpg">
            
    
        
        <div class="header">
            
            <img class="avatar" src="/Proyecto1/images/perfil.png" width="256" height="256">
            <h1 class="user-name" ><%=d.getNombre()%></h1>
            </div>
        
        
        <div class="segundo" >
             
    

               <h2>Informacion de Citas Medicas</h2>
                  
           <div>
       
              <p>Filtrar citas por:<input type="text" name="consulta" class="form_input" placeholder="Nombre paciente"> o 
              <input name="nombre" type="text" name="horario" class="form_input" placeholder="estado">
              <input type="submit" name="filtrar"  value="filtrar" class="form_input2"  width="200" height="200" >
              </p>

         
               <div class="div_citas">
                   
            
                  <br>
                
        
                  
                   
                  </div>
             
                 
               </div>
           
           <br>
           
          
         <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

                </ul>
        </div>
           
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
