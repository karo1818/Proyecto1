<%@page import="javax.swing.JOptionPane"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<HTML>
       <HEAD>
       <TITLE>Listado de Medicos </TITLE>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="css/listaMed.css" rel="stylesheet" type="text/css"/>
       </HEAD>
       
       
       <BODY>
       <H1>Listado de Medicos </H1>
       
        <%Connection con = null;%>
        <%try {%>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT * FROM Medico");%>
            <%ResultSet rs = statement.executeQuery();%>
            <TABLE BORDER="1">
            <TR>
            <TH>ID</TH>
            <TH>Clave</TH>
            <TH>Nombre</TH>
            <TH>Especialidad</TH>
            <TH>Ciudad</TH>
            <TH>Horario</TH>
            <TH>Frecuencia Citas</TH>
            <TH>Costo</TH>
            </TR>    
            <%while(rs.next()){ %>                
                <TR>
                <TD> <%= rs.getString(1)%> </td>
                <TD> <%= rs.getString(2)%> </TD>
                <TD> <%= rs.getString(3)%> </TD>
                <TD> <%= rs.getString(4)%> </TD>
                <TD> <%= rs.getString(5)%> </TD>
                <TD> <%= rs.getString(6)%> </TD>
                <TD> <%= rs.getString(7)%> </TD>
                <TD> <%= rs.getString(8)%> </TD>
               </TR>
                <%} %>         
            </TABLE>
            <%con.close();%>
        <%} catch (Exception e) {%>
            <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de medicos vacia ", JOptionPane.ERROR_MESSAGE);%>
        <%}%>
       <a class="botom" href="/Proyecto1/IngresoAdmi.jsp">Regresar</a></a> <br><br><br>
     </BODY>
</HTML>