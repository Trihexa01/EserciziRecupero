/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese_frequenze;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author molli_flavio
 * 
 * - Gradi di parallelismo 6 (5 thread)
 * - Il main interagisce con l'utente
 * - chiedere di inserire il nome del comune da cui vuole partire e quello a cui vuole arrivare
 * - inserire orario di partenza e arrivo 
 * - cercare all'interno dei 5 thread se c'è una corsa che soddisfa i requisiti richiesti
 * - Dati condivisi: 
 *  coppieOrari = elenco ore da visualizzare
 *  corseTrovate = num corse trovate
 *  elencoCorse = Ogni corsa è un elenco di orari
 *  
 * - mutua esclusione: 
 */
public class ESE_Frequenze {

   public static void main(String[] args) throws InterruptedException {
       // TODO code application logic here
        String fermate = "";
        Scanner scanner = new Scanner(System.in);
   System.out.println("Inserisci le fermate:(ogni fermata deve essere diviso da una ,)");
        fermate = scanner.nextLine();
        fermate+=", ";
        String[] fermateBus = fermate.split(",");
        ArrayList<String[]> elencoCorse = new ArrayList<String[]>();
        elencoCorse.add (AddCorsa(1));
        elencoCorse.add (AddCorsa(2));
        elencoCorse.add (AddCorsa(3));
        elencoCorse.add (AddCorsa(4));
        elencoCorse.add (AddCorsa(5));
        String ComunePartenza = "";
        String ComuneArrivo = "";
        System.out.println("Inserisci il comune di partenza");
        ComunePartenza = scanner.nextLine();
        System.out.println("Inserisci il comune di arrivo");
        ComuneArrivo = scanner.nextLine();
        //Thread
        DatiCondivisi datiCon = new DatiCondivisi(ComunePartenza, ComuneArrivo, fermateBus, elencoCorse);
        CercaTh th1 = new CercaTh(datiCon, 0);
        CercaTh th2 = new CercaTh(datiCon, 1);
        CercaTh th3 = new CercaTh(datiCon, 2);
        CercaTh th4 = new CercaTh(datiCon, 3);
        CercaTh th5 = new CercaTh(datiCon, 4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();
        //al termine il programma visualizzerà il numero di corse trovate e gli orari di ogni corsa
        if (datiCon.getCountCorseTrovate() > 0) {
            System.out.println("Corse trovate:" + datiCon.getCountCorseTrovate());
            visualizza(datiCon.getOrePartArr());
        } else {
            System.out.println("Corse non trovate");
        }
    }
    private static String[] OrariDiPartenza = new String[5];

 //Metodo per mettere gli orari delle corse negli array
    private static String[] AddCorsa(int i) {
        Scanner scanner = new Scanner(System.in);
        String[] Corsa;
        String orari = "";
        System.out.println("Inserisci gli orari della corsa " + i + "(:ogni orario deve essere diviso da una ,)");
        orari = scanner.nextLine();
        orari+=", ";
        Corsa = orari.split(",");
        return Corsa;
    }
//Visualizza l'array

    private static void visualizza(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!(array[i].equals(""))) {
                System.out.println(array[i]);
            }
        }
    }
}
