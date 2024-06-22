import javax.swing.*;
import java.awt.*;

public class RemoveAccount extends JDialog {
    private JTextField numeroContaField;
    private Banco banco;

    public RemoveAccount(JFrame parent, Banco banco) {
        super(parent, "Remover Conta", true);
        this.banco = banco;
        setLayout(new GridLayout(2, 2, 10, 10));
        
        // Set dark theme
        getContentPane().setBackground(new Color(43, 43, 43));

        // Create components
        numeroContaField = new JTextField();
        JButton removerButton = new JButton("Remover");

        // Set colors
        numeroContaField.setBackground(new Color(60, 63, 65));
        numeroContaField.setForeground(new Color(187, 187, 187));
        removerButton.setBackground(new Color(60, 63, 65));
        removerButton.setForeground(new Color(187, 187, 187));

        // Add components
        add(new JLabel("Número da Conta:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(numeroContaField);
        add(new JLabel());
        add(removerButton);

        removerButton.addActionListener(e -> removerConta());

        setSize(400, 100);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void removerConta() {
        try {
            int numeroConta = Integer.parseInt(numeroContaField.getText());
            ContaBancaria conta = banco.procurarConta(numeroConta);
            if (conta != null) {
                banco.remover(conta);
                JOptionPane.showMessageDialog(this, "Conta removida com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Conta não encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número de conta válido.");
        }
    }
}
