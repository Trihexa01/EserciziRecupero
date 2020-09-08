/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese_cerca;

/**
 *
 * @author molli_flavio
 */
public class CercaTh extends Thread {
     //Costruttore
    public CercaTh(DatiCondivisi datiCon, int numeroTh) {
        this.datiCon = datiCon;
        this.numeroTh = numeroTh;
    }

    //run
    //facendo utilizzo di thread ricercare un numero nella sequenza e determinare la posizione in cui si trova
    @Override
    public void run() {
        //Dati
        int[] numeriUtente = datiCon.getNumeriUtente();
        int[] sequenzaCasuale = datiCon.getSequenzaCasuale();
        int lung = datiCon.getLung();
        boolean trovato = datiCon.isTrovato();
        int i=0;
        //ricerca
        while (trovato == false && i<lung) {
            
            if(numeriUtente[numeroTh-1]==sequenzaCasuale[i]){
            //    
                trovato=true;
                datiCon.SemWait(1);
                datiCon.setTrovato(trovato);
                datiCon.setPos(i);
                datiCon.SemSignal(1);
            }
                
            i++;
          
        }
 
    }
    //Dati Condivisi
    DatiCondivisi datiCon;
    //Numero Thread
    int numeroTh;
}
