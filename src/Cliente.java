import javax.swing.*;

public class Cliente extends Thread{
    private JTextArea areatexto;
    private AtendimentoSimulado atendimentoSimulado;

    public Cliente(JTextArea areatexto, AtendimentoSimulado atendimentoSimulado){
        this.areatexto = areatexto;
        this.atendimentoSimulado = atendimentoSimulado;
    }

    public void run(){
        atendimentoSimulado.processo(areatexto);
    }
}
