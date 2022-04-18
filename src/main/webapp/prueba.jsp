<%-- 
    Document   : prueba
    Created on : 17 abr. 2022, 18:43:34
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%int freq = 15;%>
        <%int hora = 14;%>
        <%int minutos = 0;%>
        <%while(hora < 18){%>
        <input type="button" name="citas" class="form_input" value="<%=hora%>:<%=minutos%>" onclick="location.href='NuevaCita.jsp'">
        <%    minutos+=freq;%>
        <%    if(minutos==60){%>
        <%        minutos=0;%>
        <%    hora=(hora+1)%24;%>
       <% }%>
            
       <% }%>
    </body>
</html>
