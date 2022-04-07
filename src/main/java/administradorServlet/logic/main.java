package administradorServlet.logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import medicoServlet.logic.Medico;


public class main {
    public static void main(String[] args) {
    
        Medico med= new Medico();
        System.out.println("INICIO");
        System.out.println(med.busqMedico(15, "123"));
        System.out.println("FIN");
        

    }
}
