import javax.swing.*;
import java.awt.*;

public class Transfer extends JDialog {
    private JTextField numeroContaOrigemField;
    private JTextField numeroContaDestinoField;
    private JTextField valorField;
    private Banco banco;

    public Transfer(JFrame parent, Banco banco) {
        super(parent, "Transferir", true);
        this.banco = banco;
        setLayout(new GridLayout(4, 2, 10, 10));
        
        // Set dark theme
        getContentPane().setBackground(new Color(43, 43, 43));

        // Create components
        numeroContaOrigemField = new JTextField();
        numeroContaDestinoField = new JTextField();
        valorField = new JTextField();
        JButton transferirButton = new JButton("Transferir");

        // Set colors
        numeroContaOrigemField.setBackground(new Color(60, 63, 65));
        numeroContaOrigemField.setForeground(new Color(187, 187, 187));
        numeroContaDestinoField.setBackground(new Color(60, 63, 65));
        numeroContaDestinoField.setForeground(new Color(187, 187, 187));
        valorField.setBackground(new Color(60, 63, 65));
        valorField.setForeground(new Color(187, 187, 187));
        transferirButton.setBackground(new Color(60, 63, 65));
        transferirButton.setForeground(new Color(187, 187, 187));

        // Add components
        add(new JLabel("Conta Origem:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(numeroContaOrigemField);
        add(new JLabel("Conta Destino:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(numeroContaDestinoField);
        add(new JLabel("Valor:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(valorField);
        add(new JLabel());
        add(transferirButton);

        transferirButton.addActionListener(e -> transferir());

        setSize(400, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void transferir() {
        try {
            int numeroContaOrigem = Integer.parseInt(numeroContaOrigemField.getText());
            int numeroContaDestino = Integer.parseInt(numeroContaDestinoField.getText());
            double valor = Double.parseDouble(valorField.getText());

            ContaBancaria contaOrigem = banco.procurarConta(numeroContaOrigem);
            ContaBancaria contaDestino = banco.procurarConta(numeroContaDestino);
            if (contaOrigem == null || contaDestino == null) {
                JOptionPane.showMessageDialog(this, "Conta de origem ou destino não encontrada.");
                return;
            }

            contaOrigem.transferir(valor, contaDestino);
            JOptionPane.showMessageDialog(this, "Transferência realizada com sucesso!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    }
}
