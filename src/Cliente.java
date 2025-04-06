import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente extends Thread{
    private int numeroCliente;
    private JTextArea areatexto;
    private AtendimentoSimulado atendimentoSimulado;
    private final ReentrantLock lock = new ReentrantLock();



    public Cliente(JTextArea areatexto, AtendimentoSimulado atendimentoSimulado, int numeroCliente){
        this.areatexto = areatexto;
        this.atendimentoSimulado = atendimentoSimulado;
        this.numeroCliente = numeroCliente;
    }

    public void run(){
        atendimentoSimulado.processo(areatexto);
    }


}
