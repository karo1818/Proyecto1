<%-- 
    Document   : IngresoPaci
    Created on : 31 mar 2022, 21:12:48
    Author     : karom
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="java.sql.Connection"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%
    HttpSession sesion = request.getSession(true);
    Paciente p = new Paciente();
    if(sesion.getAttribute("userPaci") == null){
        p  = (Paciente) request.getAttribute("paciente");
    }else{
        p = (Paciente) sesion.getAttribute("userPaci");
    }
    
 %>
 
<!DOCTYPE html>

<html>
    
    <head>
        <title>MI PERFIL</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
           <link href="../css/IngrePaci.css" rel="stylesheet" type="text/css">
    </head>
     

    
        <div class="header">
           
            <img class="avatar" src="../images/perfil.png" width="256" height="256">  
            

            <h1 class="user-name"><%=p.getNombre()%></h1>
                    
            </div>
        
        <form method="post" name="form" action="/Proyecto1/pacienteServlet/presentation/ciudades"> 
        <div class="segundo">
         <label for="cars">Elija una especialidad</label>

        <%Connection con = null;%>
        <%try {%>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT * FROM Especi");%>
            <%ResultSet rs = statement.executeQuery();%>
            <%int cont=1;%>
            <select name="especi">
            <%while(rs.next()){ %> 
                <option value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>

                <%cont++;%>
                <%} %>     
            </select> 
            <%con.close();%>
        <%} catch (Exception e) {%>
            <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);%>
        <%}%> 
      
           &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <label for="cars">Elija una ciudad:</label>
            
               <%try {%>
                <%con = ConexionMySQL.ConectarBasedeDatos1();%>
                <%CallableStatement statement = con.prepareCall("SELECT * FROM Ciudades");%>
                <%ResultSet rs = statement.executeQuery();%>
                <%int cont=1;%>
                <select name="ciudad" >
                <%while(rs.next()){ %> 
                    <option name="ciudad" value="<%= rs.getString(1)%>"><%= rs.getString(1)%></option>

                    <%cont++;%>
                    <%} %>     
                </select> 
                <%con.close();%>
            <%} catch (Exception e) {%>
                <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);%>
            <%}%>
            
            
             &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
           
            <input type="submit" name="ciudades" value="Buscar" class="form_input2"  width="100" height="256" >
             <ul class="social">

               <a class="botom" href="/Proyecto1/index.html">Regresar</a>

              </ul>
            
        <div>
                            
                            
            <%Double idPaciente= p.getID(); %>
       
            <%Connection con1 = null;%>
         
            <%con1 = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement1 = con1.prepareCall("SELECT C.estado, C.dia, C.hora, C.fecha, C.ciudad, M.nombre"
                    + " FROM Citas C, Medico M, Pacientes P"
                    + " WHERE C.paciId = P.id and P.id ="+idPaciente+" and M.id = C.medicoId" );                                 


                            ResultSet rs1 = statement1.executeQuery();
                            
                           
            %>

            <TABLE BORDER="1">
            <TR>
            <TH>Estado</TH>
            <TH>Dia</TH>
            <TH>Hora</TH>
            <TH>Fecha</TH>
            <TH>Ciudad</TH>
            <TH>Nombre Doctor</TH>
            </TR>    
            <%while(rs1.next()){ %>                
                <TR>
                <TD> <%= rs1.getString(1)%> </td>
                <TD> <%= rs1.getString(2)%> </TD>
                <TD> <%= rs1.getString(3)%> </TD>
                <TD> <%= rs1.getString(4)%> </TD>
                <TD> <%= rs1.getString(5)%> </TD>
                <TD> <%= rs1.getString(6)%> </TD>
               </TR>
                            <%} %>         
             </TABLE>
                        <%con1.close();%>
                        
                      
            
           
                            </div>
        </div>
            
        </form>    
         <footer class="footer">
            
            <h2 class="lfooter">PROYECTO PROGRAMADO </h2>
        </footer>
      
       
    
</html>
