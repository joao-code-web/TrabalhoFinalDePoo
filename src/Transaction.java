import javax.swing.*;
import java.awt.*;

public class Transaction extends JDialog {
    private JTextField numeroContaField;
    private JTextField valorField;
    private Banco banco;
    private String tipoTransacao;

    public Transaction(JFrame parent, Banco banco, String tipoTransacao) {
        super(parent, tipoTransacao.substring(0, 1).toUpperCase() + tipoTransacao.substring(1), true);
        this.banco = banco;
        this.tipoTransacao = tipoTransacao;
        setLayout(new GridLayout(3, 2, 10, 10));
        
        // Set dark theme
        getContentPane().setBackground(new Color(43, 43, 43));

        // Create components
        numeroContaField = new JTextField();
        valorField = new JTextField();
        JButton confirmarButton = new JButton("Confirmar");

        // Set colors
        numeroContaField.setBackground(new Color(60, 63, 65));
        numeroContaField.setForeground(new Color(187, 187, 187));
        valorField.setBackground(new Color(60, 63, 65));
        valorField.setForeground(new Color(187, 187, 187));
        confirmarButton.setBackground(new Color(60, 63, 65));
        confirmarButton.setForeground(new Color(187, 187, 187));

        // Add components
        add(new JLabel("Número da Conta:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(numeroContaField);
        add(new JLabel("Valor:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(valorField);
        add(new JLabel());
        add(confirmarButton);

        confirmarButton.addActionListener(e -> realizarTransacao());

        setSize(400, 150);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void realizarTransacao() {
        try {
            int numeroConta = Integer.parseInt(numeroContaField.getText());
            double valor = Double.parseDouble(valorField.getText());

            ContaBancaria conta = banco.procurarConta(numeroConta);
            if (conta == null) {
                JOptionPane.showMessageDialog(this, "Conta não encontrada.");
                return;
            }

            if (tipoTransacao.equals("depositar")) {
                conta.depositar(valor);
            } else if (tipoTransacao.equals("sacar")) {
                conta.sacar(valor);
            }

            JOptionPane.showMessageDialog(this, tipoTransacao.substring(0, 1).toUpperCase() + tipoTransacao.substring(1) + " realizado com sucesso!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    }
}
