/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificathread;

/**
 *
 * @author Tr1h3xa
 */
public class DatiCon {
    Semaforo s1;
    Semaforo s2;
    public DatiCon(){
    s1 = new Semaforo(0);
    s2 = new Semaforo(0);
    }
    public void signal(int numeroSemaforo){
        if (numeroSemaforo == 1)
        {
            s1.Signal();
        }
        else if (numeroSemaforo == 2)
        {
            s2.Signal();
        }
    }
    public void wait(int numeroSemaforo){
        if (numeroSemaforo == 1)
        {
            s1.Wait();
        }
        else if (numeroSemaforo == 2)
        {
            s2.Wait();
        }
    }
}
