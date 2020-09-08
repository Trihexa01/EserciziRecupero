/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica.tecno;

/**
 *
 * @author imbrosciano_mattia
 */
public class DatiCondivisi {
    /**
     * semmafori
     */
    Semaforo s1;
    Semaforo s2;
    /**
     * brief costruttore semplice
     */
    public DatiCondivisi()
    {
        s1=new Semaforo(1);
        s2=new Semaforo(0);

        int MAXEL;
    }
    /**
     * brief vari mettodi per gestire i segnali dei semafori
     */
    public void getSem1Signal()
    {
        s1.Signal();
    }
      public void getSem1Wait()
    {
        s1.Wait();
    }
       public void getSem2Signal()
    {
        s2.Signal();
    }
      public void getSem2Wait()
    {
        s2.Wait();
    }
   
    
}
