public class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public void roda(Conta c) {
        System.out.println("===============================");
        System.out.println("Saldo Anterior: " + c.getSaldo());  // aqui você imprime o saldo anterior
        c.atualiza(this.selic);  // atualiza a conta com a taxa selic,
        System.out.println("Saldo Atualizado: " + c.getSaldo());  // e depois imprime o saldo final
        this.saldoTotal += c.getSaldo(); // lembrando de somar o saldo final ao atributo saldoTotal
    }

    // outros métodos, colocar o getter para saldoTotal!
    public double getSaldoTotal() {
        return this.saldoTotal;
    }
}