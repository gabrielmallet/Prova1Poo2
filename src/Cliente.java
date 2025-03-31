import javax.swing.*;

public class Cliente extends Thread{
    private JTextArea areatexto;
    private RetraintLock retraintLock;

    public Cliente(JTextArea areatexto,RetraintLock retraintLock){
        this.areatexto = areatexto;
        this.retraintLock = retraintLock;
    }

    public void run(){
        retraintLock.processo(areatexto);
    }
}
