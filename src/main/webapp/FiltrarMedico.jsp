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
    

    HttpSession sesion = request.getSession(true);
    Medico m = (Medico) sesion.getAttribute("userMedi");

    String BN = String.valueOf(request.getParameter("BusqueN"));
    String BE = String.valueOf(request.getParameter("BusqueID"));
 /*  Medico m;
   m=new Medico( 
                    Double.parseDouble(request.getParameter("id")),
                    request.getParameter("nombre"),
                    request.getParameter("NB"),
                    request.getParameter("EB"));
                    request.setAttribute("medico", m); 
  
    Medico mb;                
    mb  = (Medico) request.getAttribute("medicob");
    
    
    
    m.setNB( request.getParameter("NB") );
 */

 // Medico d = new Medico( 11,  "Manuel",  122,  "Manuel",  "Odontologia",  "Guatuso",  "Lunes",  10,  10);
    

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
            <h1 class="user-name" ><%=m.getNombre()%></h1>
            </div>
        
        
        <div class="segundo" >
             
    

               <h2>Informacion de Citas Medicas</h2>
                  
           <div>
       
              <p>Filtrar citas por:<input type="text" name="consulta" class="form_input" placeholder="Nombre paciente"> o 
              <input name="nombre" type="text" name="horario" class="form_input" placeholder="estado"> 
              <input type="submit" name="filtrar"  value="filtrar" class="form_input2"  width="200" height="200" >
              </p>

         
               <div class="div_citas">
                   
            <%String nomBuscar= BN; %>
            <%if (nomBuscar!=null){ %> 
            <%Connection con1 = null;%>
         
            <%con1 = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement1 = con1.prepareCall("SELECT P.nombre, estado, dia, hora"
                    + " FROM Pacientes P, Citas C, Medico M"
                    + " WHERE M.id = C.medicoId and P.id = C.paciId and M.nombre= '"+m.getNombre()+"' and P.nombre Like"+"'"+nomBuscar+"%' and C.estado Like"+"'"+BE+"%'" );                                 


                            ResultSet rs1 = statement1.executeQuery();
                           
            %>

            <TABLE BORDER="1">
            <TR>
            <TH>Paciente</TH>
            <TH>Estado</TH>
            <TH>Dia</TH>
            <TH>hora</TH>
            </TR>    
            <%while(rs1.next()){ %>                
                <TR>
                <TD> <%= rs1.getString(1)%> </td>
                <TD> <%= rs1.getString(2)%> </TD>
                <TD> <%= rs1.getString(3)%> </TD>
                <TD> <%= rs1.getString(4)%> </TD>
               </TR>
                            <%} %>         
             </TABLE>
                        <%con1.close();%>
                        
                        <% } %>
            
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
