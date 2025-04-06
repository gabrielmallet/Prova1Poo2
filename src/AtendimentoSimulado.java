import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class AtendimentoSimulado { ;
    private final ReentrantLock lock = new ReentrantLock();
    private int numeroCliente = 0;

    public void processo(JTextArea areatexto){
        try{
            numeroCliente++;
            Thread.currentThread().setName("Cliente "+ numeroCliente);//nomeia Thread como Cliente

            areatexto.append("\n"+ Thread.currentThread().getName() + " esperando atendimento...\n");

            lock.lock();
            if(Thread.currentThread().isInterrupted()){//Checa se a Thread ja foi interrompida
                return;
            }

            areatexto.append("\n"+ Thread.currentThread().getName() + " sendo atendido...\n");
            long tempoInicio = System.currentTimeMillis();//registra o tempo quando a Thread começa a ser atendida

            Thread.sleep((long)(Math. random() * 5000));//Simulando Processo

            long tempoFim = System.currentTimeMillis();//Registra o tempo quando a Thread termina o atendimento
            long tempoTotalAtendimento = tempoFim - tempoInicio;//Calcula o tempo total do atendimento
            areatexto.append(Thread.currentThread().getName() + " Atendimento Finalizado! (Atendimento durou " + tempoTotalAtendimento + " ms)\n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            areatexto.append("\n"+ Thread.currentThread().getName() + " ATENDIMENTO INTERROMPIDO!\n");
        }finally {
            lock.unlock();
        }
    }
}
