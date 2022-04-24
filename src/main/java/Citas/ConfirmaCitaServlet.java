/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;


import Citas.Citas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import medicoServlet.logic.Medico;
import pacienteServlet.logic.Paciente;


/**
 *
 * @author Usuario
 */
@WebServlet(name = "ConfirmaCitaServlet", urlPatterns = {"/citas/registrar"})
public class ConfirmaCitaServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        Citas cit;
        
    
        try{
            HttpSession sesion = request.getSession(true);
            String hora = String.valueOf(sesion.getAttribute("horaCita"));
            String min = String.valueOf(sesion.getAttribute("minCita"));
            String fecha = String.valueOf(sesion.getAttribute("fecha"));
           
            Paciente p = (Paciente) sesion.getAttribute("userPaci");
            Medico m = (Medico) sesion.getAttribute("userMedi");
            
            cit = new Citas(8, m.getID(), p.getID(), hora+":"+min, m.getHorario(), m.getEspecialidad(), m.getCiudad(), fecha);
            request.setAttribute("cita", cit);
            cit.insertCita(cit);
            request.getRequestDispatcher("/IngresoPaci.jsp").forward(request, response);
            
        }catch(Exception e){
            request.getRequestDispatcher("/FAIL.jsp").forward( request, response);
        }
    }
    
    
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
* Handles the HTTP <code>GET</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}



/**
* Handles the HTTP <code>POST</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}



/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>    
}
    