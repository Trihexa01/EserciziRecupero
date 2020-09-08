/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificathread;

import java.util.Scanner;

/**
 *
 * @author Molli Flavio
 */
public class VerificaThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        String input = "";
        

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Premi P per lanciare (pull) i due piattelli o F per finire: ");
            input = scanner.nextLine();
            int count = 0;
            DatiCon DatiCondivisi = new DatiCon();
            ThreadPiattello th1 = new ThreadPiattello(DatiCondivisi, 1);
            ThreadPiattello th2 = new ThreadPiattello(DatiCondivisi, 2);
            ThreadProiettile th3 = new ThreadProiettile(DatiCondivisi, 1);
            ThreadProiettile th4 = new ThreadProiettile(DatiCondivisi, 2);
            if (input.equals("P")) {
                //fa partire il lancio dei piattelli
                th1.start();
                th2.start();
                Thread.sleep(50);
                do {
                    System.out.println("Premi S per sparare il primo proiettile: ");
                    input = scanner.nextLine();
                    
                    if (input.equals("S")) {
                        if (count == 0) //fa partire lo sparo
                        {
                            th3.start();

                        } else {
                            th4.start();

                        }
                        count++;
                    }
                } while (count < 2);
                
                th1.join();
                th2.join();
                th3.join();
                th4.join();
            }

        } while (!input.equals("F"));

    }

}
