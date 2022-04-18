package administradorServlet.logic;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import medicoServlet.logic.Medico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import administradorServlet.logic.DateRange;
import java.time.Month;


public class main {
    public static void main(String[] args) {
    
//        Medico med = new Medico();
//        System.out.println("INICIO");
//        System.out.println(med.busqMedico(125, "125"));
//        med.citasList(14);
//        System.out.println(med.getCitasPac().toString());
//        
//        System.out.println("FIN");
        
        LocalDate myObj = LocalDate.now();
        LocalDate myObj2 = LocalDate.of(2022, Month.APRIL, 19);
        Date date;
        date = new Date(0,0,0);
        System.out.println(myObj.getDayOfWeek());
        
        myObj.datesUntil(myObj, Period.ofDays(7));
        System.out.println(myObj.getMonth());
       DateRange datte = new DateRange(myObj , myObj2);
       System.out.println(datte.toList().toString());
//        int freq = 30;
//        int hora = 14;
//        int minutos = 0;
//        while(hora < 18){
//        System.out.println("Hora: "+hora+":"+minutos);    
//            minutos+=freq;
//            if(minutos==60){
//                minutos=0;
//            hora=(hora+1)%24;
//        }
//            
//        }
        

    }
}
