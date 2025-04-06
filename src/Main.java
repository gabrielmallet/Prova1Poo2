import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton botaostart,botaostop;
    private JTextArea areatexto;
    private JScrollPane scrollpane;
    private Cliente cliente1,cliente2,cliente3,cliente4,cliente5;
    private int numeroCliente;


    public Main(){
        setSize(500,500);
        setLayout(new FlowLayout());
        setTitle("Simulando Atendimento de Clientes");
        setLocationRelativeTo(null);

        areatexto = new JTextArea(25,40);
        scrollpane = new JScrollPane(areatexto);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollpane);

        botaostart = new JButton("Iniciar");
        botaostart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((cliente1 != null && cliente1.isAlive()) ||
                        (cliente2 != null && cliente2.isAlive()) ||
                        (cliente3 != null && cliente3.isAlive()) ||
                        (cliente4 != null && cliente4.isAlive()) ||
                        (cliente5 != null && cliente5.isAlive())){
                    JOptionPane.showMessageDialog(null,"Threads já estão em execução");
                    return;
                }
                    AtendimentoSimulado atendimentoSimulado = new AtendimentoSimulado();
                    cliente1 = new Cliente(areatexto, atendimentoSimulado,numeroCliente);
                    cliente2 = new Cliente(areatexto, atendimentoSimulado, numeroCliente);
                    cliente3 = new Cliente(areatexto, atendimentoSimulado,numeroCliente);
                    cliente4 = new Cliente(areatexto, atendimentoSimulado,numeroCliente);
                    cliente5 = new Cliente(areatexto, atendimentoSimulado,numeroCliente);
                    cliente1.start();
                    cliente2.start();
                    cliente3.start();
                    cliente4.start();
                    cliente5.start();

            }
        });
        add(botaostart);

        botaostop = new JButton("Parar");
        botaostop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente1.interrupt();
                cliente2.interrupt();
                cliente3.interrupt();
                cliente4.interrupt();
                cliente5.interrupt();
            }
        });
        add(botaostop);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}