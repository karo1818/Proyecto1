package medicoServlet.presentation;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import medicoServlet.logic.Medico;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */

@WebServlet(name = "MedicoServlet", urlPatterns = {"/medico/registrar","/medico/filtrar", "/medico/image"})
@MultipartConfig(location="C:/Users/Usuario/Pictures/Screenshots")
public class MedicoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
         final Part imagen;
         String viewUrl="";
         switch(request.getServletPath() ){
            case "/medico/registrar":           
                try{
                    Medico m;
                    m=new Medico(
                    Double.parseDouble(request.getParameter("id")),
                    String.valueOf(request.getParameter("clave")),  
                    request.getParameter("nombre"),
                    request.getParameter("confirmacion"),
                    Integer.parseInt(request.getParameter("frecuenciaCitas")) ,
                    Double.parseDouble(request.getParameter("costo")),
                    request.getParameter("ciudad"),
                    request.getParameter("horario"),
                    request.getParameter("especialidad"),
                    request.getParameter("horaInicio"),
                    request.getParameter("horaFinal"));
                    imagen=request.getPart("imagen");
                    
                    request.setAttribute("medico", m);  
                    String clave = m.getClave();
                    String confirmacion = m.getConfirmacion();
                    if(clave.equals(confirmacion)){
                         m.insertMed(m);
                         imagen.write(m.getNombre());
                         request.getRequestDispatcher("/IngresoMedi.jsp").forward( request, response);
                    }
        
                }catch(Exception e){
                    request.getRequestDispatcher("/FAIL.jsp").forward( request, response);
                }
                break;    
                
                
            case "/medico/filtrar":
    //          mb=new Medico(
    //          request.getParameter("BusqueN"),
    //          request.getParameter("BusqueID"));
    //          request.setAttribute("medicob", mb);              
                String busquedaN= String.valueOf(request.getParameter("BusqueN"));
                String busquedaID= String.valueOf(request.getParameter("BusqueID"));           
                String prueba = "Ra";            
                request.setAttribute("BusqueN", prueba);
                request.setAttribute("BusqueID", busquedaID);     
                request.getRequestDispatcher("/FiltrarMedico.jsp").forward( request, response);
                break;
                
            case "/medico/image":
                viewUrl=this.image(request,response);
                break; 
                
        }
         if(viewUrl!=null){
             request.getRequestDispatcher(viewUrl).forward(request, response);
         }
    }    
    
    private String image(HttpServletRequest request,  HttpServletResponse response) {     
        String nombre = request.getParameter("nombre");
        Path path = FileSystems.getDefault().getPath("C:/Users/Usuario/Pictures/Screenshots", nombre);
        try (OutputStream out = response.getOutputStream()) {
            Files.copy(path, out);
            out.flush();
        } catch (IOException e) {
            // handle exception
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

