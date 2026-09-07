void main() {
    IO.println("=== 1. TESTES DE VALIDAÇÕES E ERROS ===");

    try {
        Funcionario g1 = new Gerente("", "123.456.789-00", 5000.0);
    } catch (IllegalArgumentException e) {
        IO.println("Erro esperado (Nome vazio): " + e.getMessage());
    }

    try {
        Funcionario d1 = new Desenvolvedor("Carlos", "", 4000.0);
    } catch (IllegalArgumentException e) {
        IO.println("Erro esperado (CPF vazio): " + e.getMessage());
    }

    try {
        Funcionario g2 = new Gerente("Ana", "987.654.321-11", 0.0);
    } catch (IllegalArgumentException e) {
        IO.println("Erro esperado (Salário inválido): " + e.getMessage());
    }

    try {
        Funcionario v1 = new Vendedor("Lucas", "111.222.333-44", 3000.0, -500.0);
    } catch (IllegalArgumentException e) {
        IO.println("Erro esperado (Vendas inválidas): " + e.getMessage());
    }

    IO.println("\n=== 2. TESTES ISOLADOS DE CÁLCULO DE BONIFICAÇÃO/COMISSÃO ===");

    Gerente g = new Gerente("Mariana Souza", "111.222.333-00", 10000.0);
    Desenvolvedor d = new Desenvolvedor("Carlos Lima", "444.555.666-11", 7000.0);
    Vendedor v = new Vendedor("Fernanda Rocha", "777.888.999-22", 3000.0, 20000.0);

    IO.println("Bonificação Gerente (20% de 10000): R$ " + g.calcularBonificacao());
    IO.println("Bonificação Dev (10% de 7000): R$ " + d.calcularBonificacao());
    IO.println("Comissão Vendedor (10% de 20000): R$ " + v.calcularBonificacao());

    IO.println("\n=== 3. EXIBIÇÃO DOS HOLERITES E FOLHA DE PAGAMENTO ===");

    List<Funcionario> funcionarios = new ArrayList<>();
    funcionarios.add(g);
    funcionarios.add(d);
    funcionarios.add(v);

    double totalFolha = 0.0;

    for (Funcionario f : funcionarios) {
        f.exibirHolerite();
        totalFolha += f.calcularRemuneracaoTotal();
    }

    IO.println("Total da folha de pagamento: R$ " + String.format("%.2f", totalFolha));
}    