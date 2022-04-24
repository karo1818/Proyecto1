/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
@WebServlet(name = "PruebaServlet", urlPatterns = {"/prueba/citas" })
public class horarioExtendServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        try{
        String hour = String.valueOf(request.getParameter("hour"));
        String minn = String.valueOf(request.getParameter("minn"));
        
        Double medId = Double.parseDouble(request.getParameter("medId"));
        
        request.setAttribute("hour", hour);
        request.setAttribute("minn", minn);
        request.setAttribute("medId", medId);
        HttpSession sesion = request.getSession(true);
        
        sesion.getAttribute("minn");
  
        
        request.getRequestDispatcher("/confirmaCita.jsp.jsp").forward( request, response);
        
        }catch(Exception e){
           request.getRequestDispatcher("/IngresoPaci.jsp").forward( request, response);  
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
