<%-- 
    Document   : IngresoMedi
    Created on : 31 mar 2022, 21:12:14
    Author     : karom
        <%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%-- 
    Document   : IngresoMedi
    Created on : 31 mar 2022, 21:12:14
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

%>
 

<!DOCTYPE html>
<html>
  
        
    <head>
        <title>Sistema Medico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
         <link href="/Proyecto1/css/IngreMedi.css" rel="stylesheet" type="text/css">
    </head>
        <body background="../images/fondo.jpg">
            
       <form method="POST" name="medico" action="/Proyecto1/medico/filtrar">
        
        <div class="header">
            
            <img class="avatar" src='/Proyecto1/medico/image?nombre=<%=m.getNombre()%>'>
            <h1 class="user-name" ><%=m.getNombre()%> </h1>
            </div>
        
        
        <div class="segundo" >
             
    
      
               <h2>Informacion de Citas Medicas</h2>
                  
           <div>
       
              <p>Filtrar citas por:<input type="text" name="BusqueN"  class="form_input" placeholder="Nombre paciente"> o 
              <input type="text" name="BusqueID" class="form_input" placeholder="estado">
               <input type="submit" name="filtrar" value="filtrar" class="form_input2" width="100" height="256" >
              
                   
              </p>

  
              <div class="div_citas">
                                 

                  <br>
    
            <%Connection con = null;%>
            <%try { %>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT P.nombre, estado, dia, hora"
                    + " FROM Pacientes P, Citas C, Medico M"
                    + " WHERE M.id = C.medicoId and P.id = C.paciId and M.nombre= '"+m.getNombre()+"'");


                            ResultSet rs = statement.executeQuery();
                           
            %>

            <TABLE BORDER="1">
            <TR>
            <TH>Paciente</TH>
            <TH>Estado</TH>
            <TH>Dia</TH>
            <TH>hora</TH>
            </TR>    
            <%while(rs.next()){ %>                
                <TR>
                <TD> <%= rs.getString(1)%> </td>
                <TD> <%= rs.getString(2)%> </TD>
                <TD> <%= rs.getString(3)%> </TD>
                <TD> <%= rs.getString(4)%> </TD>
               </TR>
                            <%} %>         
             </TABLE>
                        <%con.close();%>
                    <%} catch (Exception e) {%>
                        <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de medicos vacia ", JOptionPane.ERROR_MESSAGE);%>
                    <%}%>
 
                  
                  <br>
                                
                  </div>
                   
               </div>

           <br>
                                   

          
         <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

                </ul>
        </div>
           
      </form> 
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
        
       
    </body>
</html>

