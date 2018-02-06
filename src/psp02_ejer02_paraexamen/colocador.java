/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02_ejer02_paraexamen;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class colocador implements Runnable {

    int[] cadena;
    Semaphore[] semaforos;

    public colocador(int[] cadena, Semaphore[] semaforos) {
        this.cadena = cadena;
        this.semaforos = semaforos;
    }

    @Override
    public void run() {

        while (true) {           
            
            //ESPERAMOS MEDIO SEGUNDO
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(colocador.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < 10; i++) {
                
                if (cadena[i]==0) {
                    
                    if (semaforos[i].tryAcquire()) {
                        
                        cadena[i]= new Random().nextInt(4);
                        System.out.println("COLOCADOR: Se ha colocado un paquete en la posicion "+ i);
                        semaforos[i].release();
                        
                    }else{
                        System.out.println("COLOCADOR: POS-" + i + " ocupada. HILO--> " + Thread.currentThread().getName());                       
                        
                    } 
                    
                }            
                
            }
            
        }       

    }



}
