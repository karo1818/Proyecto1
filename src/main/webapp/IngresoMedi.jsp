         <%-- 
    Document   : IngresoMedi
    Created on : 31 mar 2022, 21:12:14
    Author     : karom
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="medicoServlet.logic.Medico"%>
<%
    Medico m  = (Medico) request.getAttribute("medico");
    DecimalFormat df = new DecimalFormat("####,###");
 %>
<!DOCTYPE html>
<html>
    <form method="POST" name="medico" action="medico/actualizar">
    
    <head>
        <title>Sistema Medico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
         <link href="../css/IngreMedi.css" rel="stylesheet" type="text/css">
    </head>
        <body background="../images/fondo.jpg">
            
       <form method="POST" name="medico" action="medico/actualizar">
        
        <div class="header">
            
            <img class="avatar" src="../images/perfil.png" width="256" height="256">
            <h1 class="user-name" ><%=m.getNombre()%></h1>
            </div>
        
        
        <div class="segundo" >
            
         
            
           
            <div class="izquierda">
                
                 <h2>Actualice su informacion </h2>
            
            <br><br>
             <tr ><td>Ingrese su foto de perfil: </td><td><input type="file" name="imagen" accept="image/jpg, image/gif, image/png">
            <br><br>
             <label>Elija su especialidad</label>

                <select>
                  <option value="1">Dermatologia</option>
                  <option value="2">Cardiologia</option>
                  <option value="3">Psicologia</option>
                  <option value="4">Pediatria</option>
                  <option value="5">Oncologia</option>
                </select> 
           
           <br><br>
           
            <label>Elija su localidad</label>
            
                 <select >
                  <option value="6">Alajuela</option>
                  <option value="7">San Jose</option>
                  <option value="8">Cartago</option>
                  <option value="9">Heredia</option>
                  <option value="10">Limon</option>
                  <option value="11">Guanacaste</option>
                  <option value="12">Puntarenas</option>
                </select> 
            
              <br><br>
             
              <input type="text" name="consulta" class="form_input" placeholder="Precio de consulta">
            
              <br><br>
              
              <input type="text" name="horario" class="form_input" placeholder="Horario">
              
                <br><br>
              
              <input type="text" name="frecuencia" class="form_input" placeholder="Frecuencia de citas">
              
              <br><br>
            <input type="submit" name="actualizar"  value="Actualizar" class="form_input2"  width="100" height="256" >

            
            
                </div>
               
           
            
           <div class="derecha">
               <h2>Informacion de Citas Medicas</h2>
                  
           <div>
               
             
               
              <p>Filtrar citas por:<input type="text" name="consulta" class="form_input" placeholder="Nombre paciente"> o 
              <input type="text" name="horario" class="form_input" placeholder="estado">
              <input type="submit" name="filtrar"  value="Filtrar" class="form_input2"  width="100" height="256" >
              </p>

  
              <div class="div_citas">
                  <br>
                  <table class="citas">
                          <tr>
                            <th>Paciente</th>
                            <th>Estado</th>
                            <th>Fecha</th>
                           
                          </tr>
                          <tr>
                            <td>Karo</td>
                            <td> activo</td>
                            <td>viernes</td>
                          </tr>
                          <tr>
                            <td>Raquel</td>
                            <td>inactivo</td>
                            <td>martes</td>
                          </tr>
                          <tr>
                            <td>Gabriel</td>
                            <td>activo</td>
                            <td>lunes</td>
                          </tr>
                           <tr>
                            <td>Jose</td>
                            <td>inactivo</td>
                            <td>miercoles</td>
                          </tr>
                          
                           <tr>
                            <td>Camila</td>
                            <td>activo</td>
                            <td>sabado</td>
                          </tr>
                        </table>
                  <br>
                   
                  </div>
             
               
               </div>
           
           <br>
           
          
     
        
            
                </div>
            
            
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br> <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                
                 
             <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

                </ul>
        </div>
           
        
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>
