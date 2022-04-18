package administradorServlet.logic;

import java.sql.Date;
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
        Date date = new Date(10,12,2022);
        date.setTime(1400);
        int freq = 30;
        int hora = 14;
        int minutos = 0;
        while(hora < 18){
        System.out.println("Hora: "+hora+":"+minutos);    
            minutos+=freq;
            if(minutos==60){
                minutos=0;
            hora=(hora+1)%24;
        }
            
        }
        

    }
}
