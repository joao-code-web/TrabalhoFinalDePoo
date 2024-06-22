import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JDialog {
    private JTextField numeroContaField;
    private JTextField saldoInicialField;
    private JComboBox<String> tipoContaComboBox;
    private Banco banco;

    public CreateAccount(JFrame parent, Banco banco) {
        super(parent, "Criar Conta", true);
        this.banco = banco;
        setLayout(new GridLayout(4, 2, 10, 10));
        
        // Set dark theme
        getContentPane().setBackground(new Color(43, 43, 43));

        // Create components
        numeroContaField = new JTextField();
        saldoInicialField = new JTextField();
        tipoContaComboBox = new JComboBox<>(new String[]{"Conta Corrente", "Conta Poupança"});
        JButton criarButton = new JButton("Criar");

        // Set colors
        numeroContaField.setBackground(new Color(60, 63, 65));
        numeroContaField.setForeground(new Color(187, 187, 187));
        saldoInicialField.setBackground(new Color(60, 63, 65));
        saldoInicialField.setForeground(new Color(187, 187, 187));
        tipoContaComboBox.setBackground(new Color(60, 63, 65));
        tipoContaComboBox.setForeground(new Color(187, 187, 187));
        criarButton.setBackground(new Color(60, 63, 65));
        criarButton.setForeground(new Color(187, 187, 187));

        // Add components
        add(new JLabel("Número da Conta:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(numeroContaField);
        add(new JLabel("Saldo Inicial:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(saldoInicialField);
        add(new JLabel("Tipo de Conta:", JLabel.RIGHT)).setForeground(new Color(187, 187, 187));
        add(tipoContaComboBox);
        add(new JLabel());
        add(criarButton);

        criarButton.addActionListener(e -> createAccount());

        setSize(400, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void createAccount() {
        try {
            int numeroConta = Integer.parseInt(numeroContaField.getText());
            double saldoInicial = Double.parseDouble(saldoInicialField.getText());
            String tipoConta = (String) tipoContaComboBox.getSelectedItem();

            ContaBancaria conta;
            if (tipoConta.equals("Conta Corrente")) {
                conta = new ContaCorrente(numeroConta, saldoInicial);
            } else {
                conta = new ContaPoupanca(numeroConta, saldoInicial);
            }

            banco.inserir(conta);
            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    }
}
