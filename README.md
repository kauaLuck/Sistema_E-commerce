# Sistema de Gestão de Folha de Pagamento

Projeto desenvolvido para demonstrar a aplicação prática dos pilares da **Programação Orientada a Objetos (POO)** em Java, através de um domínio de controle de funcionários, bonificações e cálculo de folha salarial.

---

## 📌 Visão Geral

O sistema gerencia diferentes tipos de colaboradores em uma organização, aplicando regras específicas de cálculo de bonificação e comissão para cada cargo, além de garantir a integridade dos dados cadastrados por meio de validações na camada de modelo.

### 🛠️ Regras de Negócio e Cargos

* **Gerente:** Bonificação fixa de **20%** sobre o salário base.
* **Desenvolvedor:** Bonificação fixa de **10%** sobre o salário base.
* **Vendedor:** Bonificação calculada como comissão de **10%** sobre o `totalVendido` no mês.
* **Validações:** Impedimento de cadastros com nomes vazios, CPFs em branco, salários zerados/negativos ou totais de vendas negativos.

---

## 💻 Pilares de POO Aplicados

* **Abstração:** A classe `Funcionario` modela o conceito genérico do colaborador, definindo o contrato dos métodos essenciais sem expor detalhes desnecessários.
* **Encapsulamento:** Todos os atributos (`nome`, `cpf`, `salario`, `totalVendido`) possuem modificador `private` e são acessados apenas via métodos de consulta (*getters*), garantindo a proteção e validação interna dos dados.
* **Herança:** As classes `Gerente`, `Desenvolvedor` e `Vendedor` estendem `Funcionario` (`extends`), reaproveitando atributos, validações e a lógica de exibição de holerite via `super()`.
* **Polimorfismo:** Sobrescrita do método abstrato `calcularBonificacao()` (`@Override`) em cada subclasse. A classe `Main` manipula uma coleção genérica `List<Funcionario>`, onde cada objeto executa sua própria regra de bonificação em tempo de execução.

---

## 📁 Estrutura do Projeto

```text
src/
├── Funcionario.java     # Classe abstrata base
├── Gerente.java         # Subclasse com bonificação de Gerência
├── Desenvolvedor.java   # Subclasse com bonificação de Dev
├── Vendedor.java        # Subclasse com regra de comissão sobre vendas
├── Main.java            # Execução de testes de validação e folha geral
└── IO.java              # Utilitário para exibição e entrada/saída
