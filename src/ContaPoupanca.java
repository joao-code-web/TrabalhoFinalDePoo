import javax.swing.JOptionPane;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(int numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            JOptionPane.showMessageDialog(null, "Saque de R$" + valor + " realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito de R$" + valor + " realizado com sucesso!");
    }

    @Override
    public void transferir(double valor, ContaBancaria contaDestino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            JOptionPane.showMessageDialog(null, "Transferência de R$" + valor + " realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para transferência.");
        }
    }

    @Override
    public void mostrarDados() {
        JOptionPane.showMessageDialog(null, "Conta Poupança\nNúmero da Conta: " + numeroConta + "\nSaldo: R$" + saldo);
    }
}