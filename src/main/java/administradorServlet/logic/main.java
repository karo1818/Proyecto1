package administradorServlet.logic;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
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
           
        Medico m = new Medico(125, "GGG", "GGG");
        m = m.busqMedicoId(126);
        String hora = m.getHoraFin();
        hora.substring(0, 1);
        System.out.println(hora.substring(0, 2));
        System.out.println(m.toString());
        
        
        ArrayList<Medico> medicos = m.medicosBD("Oncologia", "Moravia");
        int j = medicos.size();
        int i = 0;
        while(i < j){
            System.out.println(medicos.get(i).getHoras().toString());
            i++;
        }
   
        

        
        
        LocalDate myObj = LocalDate.now();
        LocalDate myObj2 = LocalDate.of(2022, Month.DECEMBER, 31);
        
//        System.out.println(myObj.getYear()+"/"+myObj.getMonthValue()+"/"+myObj.getDayOfMonth());
//        System.out.println(myObj2.getYear()+"/"+myObj2.getMonthValue()+"/"+myObj2.getDayOfMonth());
//        
//        System.out.println(myObj.getMonth());
//       
        DateRange datte = new DateRange(myObj , myObj2);
       int o = 0;
       int total = datte.toList(datte.dias(m.getHorario())).size();
       System.out.println(datte.toList(datte.dias(m.getHorario())).get(0).toString());
       while(o < total){
        System.out.println(datte.toList(datte.dias(m.getHorario())).get(o).toString());
        o++;
        }  
    }
}
