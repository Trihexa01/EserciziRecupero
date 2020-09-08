/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2verifica;

/**
 * 
 * @author MolliFlavio
 * Grado di parallelismo 5: main e 4 thread
 * Th1 riceve dall’utente un URL un carattere alla volta e li accoda ad una stringa STR  
 * Th2 legge la stringa STR, e cerca in un vettore (che simula il motore di ricerca GOOGLE)
 * tutti gli URL che contengono la stringa STR
 * e li inserisce all'interno di un vettore di stringhe VETT condiviso.  
 * Th3 legge la stringa STR, cerca in un vettore (che simula la CACHE di un browser)
 * tutti gli URL che contengono la stringa STR e li inserisce all'interno di un vettore di stringhe VETT condiviso 
 * Th4 visualizza il contenuto del vettore di stringhe VETT condiviso  
 * Dati condivisi: STR, VETT, GOOGLE e CACHE
 * Ci deve essere mutua esclusione tra primo e quarto thread poichè sfruttano le stesse risorse 
 * e fra il secondo e il terzo quando inserisco all'interno del vettore una stringa 
 */
public class Es2Verifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
