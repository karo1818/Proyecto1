/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacienteServlet.presentation;

import administradorServlet.logic.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacienteServlet.logic.Paciente;

/**
 *
 * @author Usuario
 */

@WebServlet(name = "PacienteServlet", urlPatterns = {"/paciente/ingresar"})
public class PacienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         
         Paciente p;


         try{

            p=new Paciente(Double.parseDouble(request.getParameter("ID")),
            Double.parseDouble(request.getParameter("clave")),
            Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("paciente", p);


            if(p.getID()== 2 && p.getClave()== 2 && p.getIngreso() == 2 ){
             request.getRequestDispatcher("/IngresoPaci.jsp").forward( request, response);
            }else{

                    request.getRequestDispatcher("/FAIL.jsp").forward( request, response);
                }
         


         }catch(IOException | NumberFormatException | ServletException e){
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
