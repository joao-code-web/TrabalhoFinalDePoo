// Fazer a class teste👍
// testar👍
// funcionando👍


public class TesteContas {
    public static void main(String[] args) {
        ContaCorrente contaCon = new ContaCorrente(1234, 1000.00);
        ContaPoupanca contaPon = new ContaPoupanca(5678, 200.00);

        contaCon.depositar(500.00);
        contaCon.sacar(200.00);

        contaPon.depositar(300.00);
        contaPon.sacar(600.00);

        contaCon.transferir(100.00, contaPon);

        contaCon.mostrarDados();
        contaPon.mostrarDados();
    }
}
