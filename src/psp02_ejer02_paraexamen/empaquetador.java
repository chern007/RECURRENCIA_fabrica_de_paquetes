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
public class empaquetador implements Runnable {

    int[] cadena;
    Semaphore[] semaforos;
    int numPaquete;

    public empaquetador(int[] cadena, Semaphore[] semaforos, int numPaquete) {
        this.cadena = cadena;
        this.semaforos = semaforos;
        this.numPaquete = numPaquete;
    }

    @Override
    public void run() {

        while (true) {

            //ESPERAMOS 1'5 SEGUNDOS
            try {
                sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(colocador.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < 10; i++) {

                if (cadena[i] == numPaquete) { //si el paquete es del numero que esta especializado el empaquetador

                    if (semaforos[i].tryAcquire()) {
                        
                        System.out.println("EMPAQUETADOR " + numPaquete + ": Se ha empaquetado el elemento " + i + " (" + cadena[i] + ")");
                        cadena[i] = 0;//vaciamos el contenido
                        semaforos[i].release();

                    } else {
                        System.out.println("EMPAQUETADOR: POS-" + i + " vacia. HILO--> " + Thread.currentThread().getName());

                    }

                }

            }

        }

    }

}
