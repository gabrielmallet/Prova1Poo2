import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class AtendimentoSimulado { ;
    private final ReentrantLock lock = new ReentrantLock();

    public void processo(JTextArea areatexto){
        try{
            areatexto.append("\n"+ Thread.currentThread().getName() + " esperando atendimento...\n");

            Thread.sleep(1000);
            lock.lock();
            if(Thread.currentThread().isInterrupted()){
                return;
            }

            areatexto.append("\n"+ Thread.currentThread().getName() + " sendo atendido...\n");
            long tempoInicio = System.currentTimeMillis();

            Thread.sleep((long)(Math. random() * 5000));//Simulando Processo

            long tempoFim = System.currentTimeMillis();
            long tempoTotalAtendimento = tempoFim - tempoInicio;
            areatexto.append(Thread.currentThread().getName() + " Atendimento Finalizado! (Atendimento durou " + tempoTotalAtendimento + " ms)\n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            areatexto.append("\n"+ Thread.currentThread().getName() + " ATENDIMENTO INTERROMPIDO!\n");
        }finally {
            lock.unlock();
        }
    }
}
