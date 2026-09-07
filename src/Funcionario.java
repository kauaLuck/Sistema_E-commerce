public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        validarDados(nome, cpf, salario);
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    private void validarDados(String nome, String cpf, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio, tente novamente!");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio, tente novamente!");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero, tente novamente!");
        }
    }

    public abstract double calcularBonificacao();

    public double calcularRemuneracaoTotal(){
        return this.salario + calcularBonificacao();
    }

    public void exibirHolerite() {
        IO.println("------------ Holerite ---------------");
        IO.println("Funcionário: " + this.nome);
        IO.println("Cargo: " + this.getClass().getSimpleName());
        IO.println("Salário: R$ " + String.format("%.2f", this.salario));
        IO.println("Bonificação: R$ " + String.format("%.2f", calcularBonificacao()));
        IO.println("Remuneração total: R$ " + String.format("%.2f", calcularRemuneracaoTotal()));
        IO.println("--------------------------------------");
    }
}
