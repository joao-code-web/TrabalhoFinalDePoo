import java.awt.*;
import javax.swing.*;

public class InforBank extends JFrame {
  private Banco banco;

  public InforBank() {
    banco = new Banco();
    setTitle("Infor Bank");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    getContentPane().setBackground(new Color(43, 43, 43));

    JPanel mainPanel = new JPanel(new GridLayout(2, 1));
    mainPanel.setBackground(new Color(43, 43, 43));
    JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
    buttonPanel.setBackground(new Color(43, 43, 43));

    JButton createAccountButton = new JButton("Criar Conta");
    JButton showAccountsButton = new JButton("Exibir Contas");
    JButton depositButton = new JButton("Depositar");
    JButton withdrawButton = new JButton("Sacar");
    JButton transferButton = new JButton("Transferir");
    JButton removeAccountButton = new JButton("Remover Conta");

    createAccountButton.setBackground(new Color(60, 63, 65));
    createAccountButton.setForeground(new Color(187, 187, 187));
    showAccountsButton.setBackground(new Color(60, 63, 65));
    showAccountsButton.setForeground(new Color(187, 187, 187));
    depositButton.setBackground(new Color(60, 63, 65));
    depositButton.setForeground(new Color(187, 187, 187));
    withdrawButton.setBackground(new Color(60, 63, 65));
    withdrawButton.setForeground(new Color(187, 187, 187));
    transferButton.setBackground(new Color(60, 63, 65));
    transferButton.setForeground(new Color(187, 187, 187));
    removeAccountButton.setBackground(new Color(60, 63, 65));
    removeAccountButton.setForeground(new Color(187, 187, 187));

    createAccountButton.addActionListener(e -> showCreateAccount());
    showAccountsButton.addActionListener(e -> showAccounts());
    depositButton.addActionListener(e -> showDeposit());
    withdrawButton.addActionListener(e -> showWithdraw());
    transferButton.addActionListener(e -> showTransfer());
    removeAccountButton.addActionListener(e -> showRemoveAccount());

    buttonPanel.add(createAccountButton);
    buttonPanel.add(showAccountsButton);
    buttonPanel.add(depositButton);
    buttonPanel.add(withdrawButton);
    buttonPanel.add(transferButton);
    buttonPanel.add(removeAccountButton);

    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JLabel welcomeLabel = new JLabel("Bem-vindo ao Infor Bank!", JLabel.CENTER);
    welcomeLabel.setForeground(new Color(187, 187, 187));
    mainPanel.add(welcomeLabel);
    mainPanel.add(buttonPanel);

    add(mainPanel, BorderLayout.CENTER);
    setVisible(true);
  }

  private void showCreateAccount() {
    new CreateAccount(this, banco);
  }

  private void showAccounts() {
    new RelatorioFrame(banco.mostrarTodasAsContas());
  }

  private void showDeposit() {
    new Transaction(this, banco, "depositar");
  }

  private void showWithdraw() {
    new Transaction(this, banco, "sacar");
  }

  private void showTransfer() {
    new Transfer(this, banco);
  }

  private void showRemoveAccount() {
    new RemoveAccount(this, banco);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(InforBank::new);
  }
}
