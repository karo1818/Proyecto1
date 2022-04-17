/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacienteServlet.presentation;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Provider.Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pacienteServlet.logic.Paciente;

/**
 * @author Usuario
 */

@WebServlet(name = "PacienteServlet", urlPatterns = {"/paciente/registrar", "/cursos/add"})
//@MultipartConfig(location="..Documentos\NetBeansProjects\Proyecto1\src\main\webapp\images")


public class PacienteServlet extends HttpServlet {
     
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         String viewUrl="";
         Paciente p;
  
        try{
            
         p=new Paciente(
            Double.parseDouble(request.getParameter("id")),
            String.valueOf(request.getParameter("clave")),
            request.getParameter("nombre"),
            request.getParameter("confirmacion"));
            request.setAttribute("paciente", p);   
            
        String clave = p.getClave();
        String confirmacion = p.getConfirmacion();
              
         

        if(clave.equals(confirmacion)){
            
         p.insertPac(p);
     
         request.getRequestDispatcher("/IngresoPaci.jsp").forward( request, response);
 
        }
        
        }catch(Exception e){
 
            
            request.getRequestDispatcher("/FAIL.jsp").forward( request, response);
        }
        
         
    }
    
       private String add(HttpServletRequest request) {     
        Paciente curso = new Paciente(request.getParameter("imagen"));
        final Part imagen; 
        try {
            imagen = request.getPart("imagen");           
            imagen.write(curso.getCodigo());
            return "/IngresoPaci.jsp";
        } catch (Exception ex) {
            return "/FAIL.jsp";
        } 
    }
    
       
         private String show(HttpServletRequest request) {     
        Paciente curso = new Paciente("");
        request.setAttribute("image", curso);
        
        return "/presentation/cursos/View.jsp";
    }
    
       
    

    private String image(HttpServletRequest request,  HttpServletResponse response) {     
        String codigo = request.getParameter("imagen");
        Path path = FileSystems.getDefault().getPath("C:\\Users\\karom\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1\\src\\main\\webapp\\images", codigo);
        try (OutputStream out = response.getOutputStream()) {
            Files.copy(path, out);
            out.flush();
        } catch (IOException e) {
     
        }
        return null;
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
