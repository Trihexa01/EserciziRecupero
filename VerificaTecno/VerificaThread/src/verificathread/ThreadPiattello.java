/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificathread;

/**
 *
 * @author Molli Flavio
 */
public class ThreadPiattello extends Thread{
    DatiCon dati;
    int numeroThread;
    public ThreadPiattello (DatiCon dati,int numeroThread)
    {
        this.dati=dati;
        this.numeroThread=numeroThread;
    }
    public void run(){
        System.out.println("piattello " + numeroThread +  " PARTITO");
       dati.wait(numeroThread);
        System.out.println("piattello " + numeroThread +  " SI DISINTEGRA");
    }
}
