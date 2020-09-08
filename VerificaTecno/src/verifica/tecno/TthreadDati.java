/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica.tecno;

/**
 *
 * @author HP
 */
public class TthreadDati extends Thread{
    DatiCondivisi s;
    /**
     * brief costruttore semplice
     * @param d1 
     */
   public  TthreadDati(DatiCondivisi d1){
       s=d1;
    }
   @Override
   /**
    * brief va all'infinito stampando le varie prient per scrivere in una pagella
    */
    public void run(){
        while(true){
        s.getSem2Wait();
      System.out.println("Recupero Dati Pagella");
      System.out.println("Entra critica");
      System.out.println("Scrive Pagella");
      System.out.println("Esce critica");
      s.getSem1Signal();
        }
}
}
