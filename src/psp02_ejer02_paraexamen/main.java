/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02_ejer02_paraexamen;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Carlos
 */
//fuente: https://resolviendoejerciciosdeprogramacion.blogspot.com.es/2014/06/ejercicio-concurrencia-con-semaforos-en.html
public class main {

    /**
     * @param args the command line arguments
     */
    public static int[] cadena = new int[10];
    public static Semaphore[] semaforos = new Semaphore[10];

    public static void main(String[] args) {
        
        
        //rellenamos el array de semaforos
        for (int i = 0; i < 10; i++) {
            semaforos[i] = new Semaphore(1);
        }       

        //iniciamos los hilos
        Thread hiloColocador = new Thread(new colocador(cadena, semaforos));
        Thread hiloEmpaquetador1 = new Thread(new empaquetador(cadena, semaforos, 1));
        Thread hiloEmpaquetador2 = new Thread(new empaquetador(cadena, semaforos, 2));
        Thread hiloEmpaquetador3 = new Thread(new empaquetador(cadena, semaforos, 3));
        
        hiloColocador.start();
        hiloEmpaquetador1.start();
        hiloEmpaquetador2.start();
        hiloEmpaquetador3.start();
                        
                        
    }
    
}
