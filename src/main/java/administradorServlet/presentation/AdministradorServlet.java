package administradorServlet.presentation;

import administradorServlet.logic.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import medicoServlet.logic.Medico;
import pacienteServlet.logic.Paciente;

@WebServlet(name = "AdministradorServlet", urlPatterns = {"/administrador/ingresar"})
public class AdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         Administrador a;
         Paciente p;
         Medico m;
          

         try{

            a=new Administrador(Double.parseDouble(request.getParameter("ID")),
            Double.parseDouble(request.getParameter("clave")),           
            Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("administrador", a);

            m=new Medico(Double.parseDouble(request.getParameter("ID")),
            Double.parseDouble(request.getParameter("clave")),
            Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("medico", m);

            p=new Paciente(Double.parseDouble(request.getParameter("ID")),
            (request.getParameter("clave")),
            Double.parseDouble(request.getParameter("ingreso")));
            request.setAttribute("paciente", p);
               
           
            int respingreso=(int) a.getIngreso();
            
            switch(respingreso){
            
                case 1:
                    
                    if(a.getID()== 1 && a.getClave()== 1){
                   request.getRequestDispatcher("/IngresoAdmi.jsp").forward( request, response);
            
                     }else{   request.getRequestDispatcher("/FAIL.jsp").forward( request, response);       }
            
                     break;
                    
                case 2:    
                      
                    if( p.busqPaciente(p.getID(), p.getClave()) == true){
                
                  request.getRequestDispatcher("/IngresoPaci.jsp").forward( request, response);  
                
                  }else{ request.getRequestDispatcher("/FAIL.jsp").forward( request, response);    }
                    
                     break;
                    
                case 3:    
            
                     if(a.getID()== 3 && a.getClave()== 3){
                     request.getRequestDispatcher("/IngresoMedi.jsp").forward( request, response);
            
                     }else{   request.getRequestDispatcher("/FAIL.jsp").forward( request, response);       }
                     
                     break;
                     
                default:
                
                   request.getRequestDispatcher("/FAIL.jsp").forward( request, response);
                    break;
                    
            }
            
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
