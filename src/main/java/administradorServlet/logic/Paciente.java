/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;

/**
 *
 * @author karom
 */
public class Paciente {
    
    
      private double ID;
      private double clave;
      private double ingreso;

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }
    
    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public double getClave() {
        return clave;
    }

    public void setClave(double clave) {
        this.clave = clave;
    }
  
 
 
    

    public Paciente(double i, double c, double in) {
        
        ID= i;
        clave= c;
        ingreso= in;
    }
    
    public Paciente() {
    }



    
    
    
    
    
}
