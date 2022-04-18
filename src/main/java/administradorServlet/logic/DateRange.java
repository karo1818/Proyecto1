/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorServlet.logic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author gabri
 */
public class DateRange implements Iterable<LocalDate> {

  private final LocalDate startDate;
  private final LocalDate endDate;

  public DateRange(LocalDate startDate, LocalDate endDate) {
    //check that range is valid (null, start < end)
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

  public List<LocalDate> toList() { //could also be built from the stream() method
    List<LocalDate> dates = new ArrayList<> ();
    for (LocalDate d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
        if("MONDAY".equals(String.valueOf(d.getDayOfWeek())) || "TUESDAY".equals(String.valueOf(d.getDayOfWeek()))){
         dates.add(d);
        }
     
    }
    return dates;
  }
//  public String dias(String dia){
//      switch(dia){
//          case "Lunes":
//              return "MONDAY";
//             
//          default:
//              break;
//      }
//  }
}