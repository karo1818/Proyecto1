<%-- 
    Document   : NuevaCita
    Created on : 17 abr. 2022, 18:55:39
    Author     : gabri
--%>
<%@page import="administradorServlet.data.ConexionBD"%>
<%@page import="administradorServlet.logic.DateRange"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.LocalDate"%>
<%@page import="medicoServlet.logic.Medico"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%  String hora = String.valueOf(request.getParameter("hour"));
    String min = String.valueOf(request.getParameter("minn"));
    String fecha = String.valueOf(request.getParameter("fecha"));
    ConexionBD bases = new ConexionBD();
    
    Medico m = new Medico(125, "NULL", "NULL");
    m = bases.busqMedicoId(Double.parseDouble(request.getParameter("medId")));
    
    LocalDate myObj = LocalDate.now();
    LocalDate myObj2 = LocalDate.of(2022, Month.DECEMBER, 31);
    DateRange datte = new DateRange(myObj , myObj2);
    HttpSession sesion = request.getSession(true);
    Paciente p = (Paciente) sesion.getAttribute("userPaci");    
    int o = 0;
    int total = datte.toList(datte.dias(m.getHorario())).size();
    
%>

<%-- 
    Document   : confirmaCita
    Created on : 20 abr. 2022, 18:38:56
    Author     : Usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/Proyecto1/css/confirmCita.css?1.0" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Confirmacion de cita</title>
    </head>
    <body>
        <form method="POST" name="citaRegistro" action="/Proyecto1/citas/registrar">    
        <h1>Confirmacion de la cita</h1>
        <div>    
           
            <%sesion.setAttribute("horaCita", hora);%>
            <%sesion.setAttribute("minCita", min);%>
            <%sesion.setAttribute("userMedi", m);%> 
            <%sesion.setAttribute("fecha", fecha);%>
            <h2>Detalles de la cita</h2>
            <h2>Nombre del doctor: <%=m.getNombre()%></h2>
            <h2>Dia: <%=m.getHorario()%></h2>
            <h2>Fecha: <%=fecha%></h2>
            <h2>Hora: <%=hora%>:<%=min%></h2>
            <input id="conf" class="botom" type="submit" name="nuevaCita" value="Confirmar" class="form_input">
                  
        </div>
        </form>    
    </body>
</html>
