/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;

import java.util.List;

/**
 *
 * @author karom
 */
public class Paciente {
      private double ID;
      private String clave;
      private double ingreso;
      private String nombre;
      List <Citas> citasPac;

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Paciente(double i, String c, double in, String n) {
        
        ID= i;
        clave= c;
        ingreso= in;
        nombre=n;
    }
    
    public Paciente() {
    }
  
}
