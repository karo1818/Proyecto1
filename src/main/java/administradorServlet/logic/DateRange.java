package administradorServlet.logic;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class DateRange implements Iterable<LocalDate> {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return stream().iterator();
    }

    public Stream<LocalDate> stream() {
        return Stream.iterate(startDate, d -> d.plusDays(1))
        .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
    }

    public List<LocalDate> toList(String dia) { 
        List<LocalDate> dates = new ArrayList<> ();
        for (LocalDate d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
            if(dia.equals(String.valueOf(d.getDayOfWeek()))){
                dates.add(d);
            }
        }
        return dates;
    }
    public String dias(String dia){
        switch(dia){
            case "Lunes":
                return "MONDAY";
            case "Martes":
                return "TUESDAY";
            case "Miercoles":
                return "WEDNESDAY";
            case "Jueves":
                return "THURSDAY";
            case "Viernes":
                return "FRIDAY";
            case "Sabado":
                return "SATHURDAY";
            case "Domingo":
                return "SUNDAY";
            default:
                return "";

            }
        }
    }
