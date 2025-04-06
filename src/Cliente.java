import javax.swing.*;

public class Cliente extends Thread{
    private int numeroCliente;
    private JTextArea areatexto;
    private AtendimentoSimulado atendimentoSimulado;

    public Cliente(JTextArea areatexto, AtendimentoSimulado atendimentoSimulado, int numeroCliente){
        this.areatexto = areatexto;
        this.atendimentoSimulado = atendimentoSimulado;
        this.numeroCliente = numeroCliente;
    }

    public void run(){
        atendimentoSimulado.processo(areatexto);
    }


}
