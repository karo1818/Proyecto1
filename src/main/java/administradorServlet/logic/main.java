package administradorServlet.logic;

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
        Pacientes2 pac = new Pacientes2();
        System.out.println("INICIO");
        System.out.println(pac.pacientesBD().toString());
        System.out.println("FIN");

    }
}
