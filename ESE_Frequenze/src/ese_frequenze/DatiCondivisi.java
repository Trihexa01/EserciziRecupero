/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese_frequenze;

import java.util.ArrayList;

/**
 *
 * @author molli_flavio
 */
public class DatiCondivisi {
//Getter
    public String getComunePar() {
        return ComunePar;
    }

    public String getComuneArr() {
        return ComuneArr;
    }

    public String[] getFermateBus() {
        return fermateBus;
    }

    public ArrayList<String[]> getElencoCorse() {
        return elencoCorse;
    }
      public int getCountCorseTrovate() {
        return countCorseTrovate;
    }

    public String[] getOrePartArr() {
        return OrePartArr;
    }

    //Mettodo per incrementare il contatore dei corsi trovati
    public synchronized void  incCountCorseTrovate(){
        countCorseTrovate++;
    }
    public synchronized void push(String s){
        if(numEl<OrePartArr.length){
            OrePartArr[numEl]=s;
            numEl++;
        }
    }
    //reset array 
    private void ResetArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]="";
        }
    }

    //Costruttore
    public DatiCondivisi(String ComunePar, String ComuneArr, String[] fermateBus, ArrayList<String[]> elencoCorse) {
        this.ComunePar = ComunePar;
        this.ComuneArr = ComuneArr;
        this.fermateBus = fermateBus;
        this.elencoCorse = elencoCorse;
        countCorseTrovate = 0;
        OrePartArr = new String[fermateBus.length * 5];
        ResetArray(OrePartArr);
        numEl=0;

    }
    //Dati
    private String ComunePar;
    private String ComuneArr;
    private String[] fermateBus;
    private ArrayList<String[]> elencoCorse;

  

    private int countCorseTrovate;
    private String[] OrePartArr;
    private int numEl;

}
