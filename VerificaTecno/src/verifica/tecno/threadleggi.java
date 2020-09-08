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
public class threadleggi extends Thread{
    DatiCondivisi s;
     /**
     * brief costruttore semplice
     * @param d1 
     */
   public threadleggi(DatiCondivisi d1){
       s=d1;
    }
   
   @Override
   /**
    * brief va all'infinito stampando le varie prient per leggere in una pagella
    */
  public void run()
  {
      while(true){
       s.getSem1Wait();
      System.out.println("Entra critica");
      System.out.println("Leggi dati Pagella");
      System.out.println("Esce critica");
      System.out.println("Esce critica");
     s.getSem2Signal();
        }
  }
}
  
