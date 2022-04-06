package administradorServlet.logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import pacienteServlet.logic.Paciente;

public class main {
    public static void main(String[] args) {
        Paciente pac = new Paciente();
        System.out.println("INICIO");
        
        System.out.println(pac.busqPaciente(12, "hola23"));
        System.out.println("FIN");

    }
}
