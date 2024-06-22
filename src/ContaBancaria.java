// classe abstrata Conta Bancaria que contém como atributos o número da conta e o saldo. 👍
// métodos abstratos sacar e depositar que recebem um parâmetro do tipo double. 👍
// Crie um método em cada classe chamado mostrarDados e na implementação do método
// Crie um método chamado transferir que recebe um double e Objeto do tipo ContaBancaria, que vai haver o numeroConta e o saldo👍
// mostre os atributos de cada conta.👍

public abstract class ContaBancaria {
  protected int numeroConta;
  protected double saldo;

  public ContaBancaria(int numeroConta, double saldo) {
      this.numeroConta = numeroConta;
      this.saldo = saldo;
  }

  public int getNumeroConta() {
      return numeroConta;
  }

  public double getSaldo() {
      return saldo;
  }

  public abstract void sacar(double valor);
  public abstract void depositar(double valor);
  public abstract void transferir(double valor, ContaBancaria contaDestino);
  public abstract void mostrarDados();

  @Override
  public String toString() {
      return "Conta Número: " + numeroConta + ", Saldo: R$" + saldo;
  }
}

