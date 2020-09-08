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
public class VerificaTecno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Problema è quella della muta eslusione 
         */
        DatiCondivisi d1=new DatiCondivisi();
        TthreadDati scrivi=new TthreadDati(d1);
        threadleggi leggi=new threadleggi(d1);
        scrivi.start();
        leggi.start();
          try {
        scrivi.join();
         leggi.join();
        } catch (Exception e) {
        }
        
    }
    
}
