/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese_cerca;

import java.util.Scanner;

/**
 * chiedere all'utente una quantità LUNG maggiore di 0 e generare una sequenza di numeri casuali di lunghezza LUNG 
 * chiedere all'utente di inserire tre numeri da ricercare nella sequenza 
 * Grado di parallelismo 4
 * comunica il numero trovato e la sua posizione all'interno della sequenza
 * dati condivisi: Trovato, Posizione, Numeri, vettore.
 * 
 * Mutua esclusione serve o non serve qui???
 * Modifica di trovato e di pos
 * 
 * @author molli_flavio
 */
public class ESE_cerca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       // TODO code application logic here
        Scanner scanner = new Scanner(System.in);// Create a Scanner object
        //-chiedere all'utente una quantità LUNG maggiore di 0 
        int lung = 0;
        System.out.println("Inserire una quantita maggiore di 0");
        do {
            lung = scanner.nextInt();
        } while (lung <= 0);
        //-generare una sequenza di numeri casuali di lunghezza LUNG 
        int[] sequenzaCasuale = new int[lung];
        for (int i = 0; i < lung; i++) {
            sequenzaCasuale[i] = (int) (Math.random() * 100);
        }
        visualizza(sequenzaCasuale);
        //chiedere all'utente di inserire tre numeri da ricercare nella sequenza 
        int i = 0;
        int[] numeriUtente = new int[3];
        System.out.println("Inserire 3 numeri");
        do {
            do {
                numeriUtente[i] = scanner.nextInt();
            } while (numeriUtente[i] <= 0);
            i++;
        } while (i < 3);
        //Dati Condivisi
        DatiCondivisi datiCon = new DatiCondivisi(numeriUtente, sequenzaCasuale, lung, false);
        //Thread di ricerca
        CercaTh th1 = new CercaTh(datiCon, 1);
        CercaTh th2 = new CercaTh(datiCon, 2);
        CercaTh th3 = new CercaTh(datiCon, 3);
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();

        //il programma deve comunicare il numero trovato e la sua posizione all'interno della sequenza
        if (datiCon.isTrovato() == true) {
            System.out.println("Trovato!! La posizione all'interno della sequenza e':" + (datiCon.getPos() + 1));
        } else {
            System.out.println("Non lo trovato i numeri inseriti!!");
        }
    }
     private static void visualizza(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("" + array[i] + " ");
        }
        System.out.println("");
    }
}

    

