package administradorServlet.logic;

import medicoServlet.logic.Medico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */



public class main {
    public static void main(String[] args) {
    
        Medico med = new Medico();
        System.out.println("INICIO");
        System.out.println(med.busqMedico(125, "125"));
        med.citasList(14);
        System.out.println(med.getCitasPac().toString());
        
        System.out.println("FIN");
        

    }
}
