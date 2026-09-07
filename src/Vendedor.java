public class Vendedor extends Funcionario{
    private double totalVendido;
    public Vendedor(String nome, String cpf, double salario, double totalVendido) {
        super(nome, cpf, salario);

        validarTotalVendido(totalVendido);
        this.totalVendido = totalVendido;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    private void validarTotalVendido(double totalVendido) {
        if (totalVendido < 0) {
            throw new IllegalArgumentException("O total vendido não pode ser negativo, tente novamente!");
        }
    }


    @Override
    public double calcularBonificacao() {
        return this.totalVendido * 0.10;
    }
}
