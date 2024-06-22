import java.util.ArrayList;
import java.util.List;

public class Banco {

  private List<ContaBancaria> contas;

  public Banco() {
    contas = new ArrayList<>();
  }

  public void inserir(ContaBancaria conta) {
    contas.add(conta);
  }

  public void remover(ContaBancaria conta) {
    contas.remove(conta);
  }

  public ContaBancaria procurarConta(int numero) {
    for (ContaBancaria conta : contas) {
      if (conta.getNumeroConta() == numero) {
        return conta;
      }
    }
    return null;
  }

  public String mostrarTodasAsContas() {
    StringBuilder relatorio = new StringBuilder();
    if (contas.size() == 0) {
        relatorio.append("Não tem nenhuma conta");
    } else {
      for (ContaBancaria conta : contas) {
        relatorio.append(conta.toString()).append("\n");
      }
    }
    return relatorio.toString();
  }
}