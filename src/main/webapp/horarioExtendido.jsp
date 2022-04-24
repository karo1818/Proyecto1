<%-- 
    Document   : horarioExtendido
    Created on : 23 abr. 2022, 20:58:21
    Author     : gabri
--%>
<%@page import="Citas.Citas"%>
<%@page import="administradorServlet.logic.DateRange"%>
<%@page import="java.time.LocalDate"%>
<%@page import="pacienteServlet.logic.Paciente"%>
<%@page import="java.time.Month"%>
<%@page import="java.util.ArrayList"%>
<%@page import="medicoServlet.logic.Medico"%>
<%@page import="java.time.LocalTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Medico m = new Medico(125, "GGG", "GGG");
    m = m.busqMedicoId(Double.parseDouble(request.getParameter("medId")));
    
    String ciudad = String.valueOf(request.getParameter("ciudad"));
    String especi = String.valueOf(request.getParameter("especi"));
    HttpSession sesion = request.getSession(true);
    ArrayList<Medico> medicos = m.medicosBD(especi, ciudad);
    Paciente p = (Paciente) sesion.getAttribute("userPaci");   
 
    LocalDate myObj = LocalDate.now();
    LocalDate myObj2 = LocalDate.of(2022, Month.DECEMBER, 31);
    DateRange datte = new DateRange(myObj , myObj2);
    Citas c = new Citas();
%>    
<!DOCTYPE html>
<link href="/Proyecto1/css/horarioExtendido.css?1.0" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       <form method="POST" name="prueba" action="/Proyecto/prueba/citas">
       
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
    
    
    <div class="pacienteInfo">
        
        <%if(p != null){%>
            <h1><img src="/Proyecto1/images/iconoP.png" class="iconPac"/><%=p.getNombre()%></h1>
    
        <%}%>     
    </div>
     
    </head>
    <body>
         <%int contHoras = 0;%>
         <%int contFechas = 0;%>

        <div class="medicos">
            
            <h1>Nombre: <%=m.getNombre() %> </h1>
            <h2>Dia de atencion: <%=m.getHorario() %></h2>
            <h2>Costo de la consulta: <%=m.getCosto()%></h2>
            
  
          
            
            <%int totalHoras = m.getHoras().size();%><br><br> 
        </div>  
      
        <div class="clear"></div>
        <div class="fechas">  
            <%while(contFechas < 8){%>
            <h3>Fecha de la proxima cita: <%=datte.toList(datte.dias(m.getHorario())).get(contFechas).toString()%></h3>
          
                <div class="horario">
           
                    <%while(contHoras < totalHoras){%>
            
                    <%if(c.citaDisponible(m.getID(), m.getHoras().get(contHoras).getHour()+":"+m.getHoras().get(contHoras).getMinute(), datte.toList(datte.dias(m.getHorario())).get(contFechas).toString())){%>
                        <div class="spannDiv">
                        <span class="bg-appointment-disable text12"><%=m.getHoras().get(contHoras)%></span></div>
                        <br>
                    <%}else{%>
                        <div class="horasDiv">

                        <a class="horas" href="/Proyecto1/confirmaCita.jsp?hour=<%=m.getHoras().get(contHoras).getHour()%>&minn=<%=m.getHoras().get(contHoras).getMinute()%>&medId=<%=m.getID()%>&fecha=<%=datte.toList(datte.dias(m.getHorario())).get(contFechas).toString()%>"><%=m.getHoras().get(contHoras).getHour()%>:<%=m.getHoras().get(contHoras).getMinute()%></a>
                
                        <br>
                        </div><br><br>
                        <%}%>
                        <%contHoras++;%>
                    <%}%>
                    <%contHoras = 0;%>
                    <%contFechas++;%>
                    
                </div>
            </div>
            <%}%>
             
       
        
        </form> 
    </body>
</html>
