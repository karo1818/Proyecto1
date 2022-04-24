
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="administradorServlet.data.ConexionMySQL"%>
<%@page import="administradorServlet.logic.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%Administrador admin = (Administrador) request.getAttribute("administrador");%>
<HTML>
            <HEAD>
            <TITLE>Listado de Ciudades </TITLE>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <link href="/Proyecto1/css/listaC.css" rel="stylesheet" type="text/css"/>
                    </HEAD>
                    <BODY>
                                <form method="POST" name="ciudadRegistro" action="/Proyecto1/ciudad/registrar">
                                <H1>Listado de Ciudades </H1>
                                <TABLE BORDER="1">
                                <TR>
                                <TH>Nombre</TH>
                                            </TR>
                                            <%ArrayList<String> listaC = new ArrayList();%>
                                            <%listaC=listadociud();%>
                                            <%for(int i=0;i<listaC.size();i++){ %>
                                            <TR>
                                            <TD> <%= listaC.get(i).toString()%> </td>
                                            </TR>
                                            <%} %>
                                            </TABLE> 
                                
                                
                                <div class ="padre">
                                <div class="hijo">
                                    <br><br>
                                            <input class="hijo" type="text" name="RegistraCiud" class="form_input" placeholder="Nombre de la ciudad"><br><br>
                                            <input  class="hijo" type="submit" name="registrar" value="Registrar ciudad" class="form_input"><br><br>
                                            <a class="hijo" class="botom" href="/Proyecto1/IngresoAdmi.jsp">Regresar</a></a> <br><br><br>
                                            </form>
                                            </div>
                                
                                </div>
                                
                                            </BODY>
                                            </HTML><%!
                                            public ArrayList<String> listadociud(){
                                            Connection con = null;
                                            ArrayList listaS = new ArrayList<String>();
                                            try {
                                            con = ConexionMySQL.ConectarBasedeDatos1();
                                            CallableStatement statement = con.prepareCall("SELECT * FROM Ciudades");
                                            ResultSet rs = statement.executeQuery();
                                while(rs.next()){
                                listaS.add(rs.getString(1));
                                } con.close();
                                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de ciudades vacia ", JOptionPane.ERROR_MESSAGE);
                    }
            return listaS;
            }
%>

