<%@page import="javax.swing.JOptionPane"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<HTML>
       <HEAD>
       <TITLE>Listado de Especialidades </TITLE>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="css/listaE.css" rel="stylesheet" type="text/css"/>        
       </HEAD>
       
       
       <BODY>
       <H1>Listado de Especialidades </H1>       
        <%Connection con = null;%>
        <%try {%>
            <%con = ConexionMySQL.ConectarBasedeDatos1();%>
            <%CallableStatement statement = con.prepareCall("SELECT * FROM Especi");%>
            <%ResultSet rs = statement.executeQuery();%>
            <TABLE BORDER="1">
            <TR>
            <TH>Nombre</TH>
            </TR>    
            <%while(rs.next()){ %>                
                <TR>
                <TD> <%= rs.getString(1)%> </td>
               </TR>
                <%} %>         
            </TABLE>
            <%con.close();%>
        <%} catch (Exception e) {%>
            <%JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);%>
        <%}%>
       <a class="botom" href="/Proyecto1/IngresoAdmi.jsp">Regresar</a></a> <br><br><br>
       
     </BODY>
</HTML>
