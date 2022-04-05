package medicoServlet.presentation;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import medicoServlet.logic.Medico;
import pacienteServlet.logic.Paciente;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */

@WebServlet(name = "MedicoServlet", urlPatterns = {"/medico/ingresar"})
public class MedicoServlet extends HttpServlet {

      ArrayList<Medico> listaMed= new ArrayList<>();
        Medico medico = new Medico();
    
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         
         Medico m;


         try{

            m=new Medico(Double.parseDouble(request.getParameter("ID")),
            Double.parseDouble(request.getParameter("clave")),
            Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("medico", m);


            if(m.getID()== 3 && m.getClave()== 3 && m.getIngreso() == 3 ){
             request.getRequestDispatcher("/IngresoMedi.jsp").forward( request, response);
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