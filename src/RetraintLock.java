import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class RetraintLock{ ;
    private final ReentrantLock lock = new ReentrantLock();

    public void processo(JTextArea areatexto){
        try{
            areatexto.append(Thread.currentThread().getName() + " esperando atendimento...\n");

            lock.lock();
            if(Thread.currentThread().isInterrupted()){
                return;
            }
            areatexto.append(Thread.currentThread().getName() + " sendo atendido...\n");
            long tempoInicio = System.currentTimeMillis();
            Thread.sleep((long)(Math. random() * 5000));
            long tempoFim = System.currentTimeMillis();
            long tempoTotalAtendimento = tempoFim - tempoInicio;
            areatexto.append(Thread.currentThread().getName() + " Atendimento Finalizado! (Atendimento durou " + tempoTotalAtendimento + " ms)\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            areatexto.append(Thread.currentThread().getName() + " ATENDIMENTO INTERROMPIDO!\n");
        }finally {
            lock.unlock();
        }
    }
}
