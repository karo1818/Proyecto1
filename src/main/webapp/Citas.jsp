<%-- 
    Document   : prueba
    Created on : 17 abr. 2022, 18:43:34
    Author     : gabri
--%>

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
    String ciudad = String.valueOf(request.getParameter("ciudad"));
    String especi = String.valueOf(request.getParameter("especi"));
    HttpSession sesion = request.getSession(true);
    ArrayList<Medico> medicos = m.medicosBD(especi, ciudad);
    Paciente p = (Paciente) sesion.getAttribute("userPaci");   
 
    LocalDate myObj = LocalDate.now();
    LocalDate myObj2 = LocalDate.of(2022, Month.DECEMBER, 31);
    DateRange datte = new DateRange(myObj , myObj2);
%>
<!DOCTYPE html>
<html>
    <title>Citas</title>
    <link href="/Proyecto1/css/Citas.css?6.0" rel="stylesheet" type="text/css"/>
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
        <%int totalMed = medicos.size();%>
        <%int contMed = 0;%>
        
        <div class="principal">
        
        <%while(contMed < totalMed){%>
        <div class="medicos">
            <h1> <%=medicos.get(contMed).getNombre() %></h1>
            
            <%int totalHoras = medicos.get(contMed).getHoras().size();%>
        </div>   
        
       <div class="horario">
            <%while(contHoras < totalHoras){%>
            
            <%if(medicos.get(contMed).getHoras().get(contHoras).getHour() == 19){%>
                <div class="spannDiv">
                <span class="bg-appointment-disable text12"><%=medicos.get(contMed).getHoras().get(contHoras)%></span></div>
                <br>
             <%}else{%>
                <div class="horasDiv">
                  
                 
                <a class="horas" href="/Proyecto1/confirmaCita.jsp?hour=<%=medicos.get(contMed).getHoras().get(contHoras).getHour()%>&minn=<%=medicos.get(contMed).getHoras().get(contHoras).getMinute()%>&medId=<%=medicos.get(contMed).getID()%>"><%=medicos.get(contMed).getHoras().get(contHoras).getHour()%>:<%=medicos.get(contMed).getHoras().get(contHoras).getMinute()%></a>
                
                <br>
                </div><br><br>
                <%}%>
                <%contHoras++;%>
            <%}%>
            <%contHoras = 0;%>
        <%contMed++;%>
       </div>
        <%}%>
       
        </div>
        </form> 
       
       
       
    </body>
</html>
