/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificathread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tr1h3xa
 */
public class ThreadProiettile extends Thread{

    public ThreadProiettile(DatiCon dati, int NumeroThread) {
        this.dati = dati;
        this.NumeroThread = NumeroThread;
    }
  DatiCon dati;
  int NumeroThread;
  public void run(){
      System.out.println("proiettile "+NumeroThread+ " PARTITO ");
      
      try {
          Thread.sleep((long )(Math.random()*1+1)*1000);
      } catch (InterruptedException ex) {
      }    
      System.out.println("proiettile "+ NumeroThread +  " COLPISCE piattello" + NumeroThread );
      dati.signal(NumeroThread);
  }
   
}
