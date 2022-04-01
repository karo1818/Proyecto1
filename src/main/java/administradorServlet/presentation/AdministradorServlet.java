package administradorServlet.presentation;

import administradorServlet.logic.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdministradorServlet", urlPatterns = {"/administrador/ingresar"})
public class AdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         Administrador a;
         try{
         
           a=new Administrador(Double.parseDouble(request.getParameter("ID")), 
            Double.parseDouble(request.getParameter("clave")),
           Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("administrador", a);
           
            
            if(a.getID()==123456 && a.getClave()==123456 && a.getIngreso() == 3 ){
              request.getRequestDispatcher("/IngresoAdmi.jsp").forward( request, response); 
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
