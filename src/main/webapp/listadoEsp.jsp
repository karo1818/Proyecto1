<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<HTML>
<HEAD>
<TITLE>Listado de Especialidades </TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Proyecto1/css/listaE.css" rel="stylesheet" type="text/css"/>
</HEAD>


<BODY>
<form method="POST" name="especiRegistro" action="especialidad/registrar">
<H1>Listado de Especialidades </H1>
<TABLE BORDER="1">
<TR>
<TH>Nombre</TH>
</TR>
<%ArrayList<String> listaE = new ArrayList();%>
<%listaE=listadoEspe();%>
<%for(int i=0;i<listaE.size();i++){ %>
<TR>
<TD> <%= listaE.get(i).toString()%> </td>
</TR>
<%} %>
</TABLE>
<div class="form_section">
<input type="text" name="RegistraEsp" class="form_input" placeholder="Nombre de la especialidad">
<input type="submit" name="registrar" value="Registrar especialidad" class="form_input">
<a class="botom" href="/Proyecto1/IngresoAdmi.jsp">Regresar</a></a> <br><br><br>
</form>
</BODY>
</HTML>



<%!
public ArrayList<String> listadoEspe(){
Connection con = null;
ArrayList listaS = new ArrayList<String>();
try {
con = ConexionMySQL.ConectarBasedeDatos1();
CallableStatement statement = con.prepareCall("SELECT * FROM Especi");
ResultSet rs = statement.executeQuery();
while(rs.next()){
listaS.add(rs.getString(1));
}



con.close();
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de especialidades vacia ", JOptionPane.ERROR_MESSAGE);
}
return listaS;
}
%>