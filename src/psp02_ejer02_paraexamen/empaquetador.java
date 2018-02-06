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
public class empaquetador implements Runnable {

    int[] cadena;
    Semaphore[] semaforos;

    public empaquetador(int[] cadena, Semaphore[] semaforos) {
        this.cadena = cadena;
        this.semaforos = semaforos;
    }

    @Override
    public void run() {
        
        while(true){
            
            
        }
        
        
    }

}
