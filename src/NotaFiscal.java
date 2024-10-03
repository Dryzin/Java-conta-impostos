public class NotaFiscal {
    private String tipoTransacao; // defino se nota "produto" ou "servico"
    private int margemLucro; // em porcentagem
    private double preco;
    private double frete;
    private double seguro;

    // construtor
    public NotaFiscal(double preco, double frete, double seguro, int margemLucro, String tipoTransacao) {
        this.preco = preco;
        this.frete = frete;
        this.seguro = seguro;
        this.margemLucro = margemLucro;
        this.tipoTransacao = tipoTransacao;
    }

    // calcular o preço final com base no imposto
    public void calcularPrecoFinal(String imposto) {

        if (imposto == null || imposto.trim().isEmpty()) {
            System.out.println("Erro: imposto nao informado");
            return;
        }
        // uma verificacao dividindo os tipos de imposto ao tipo de notafiscal

        if (this.tipoTransacao.equalsIgnoreCase("produto") && imposto.equalsIgnoreCase("ISS")) {
            System.out.println("Erro: iss nao se adiciona a produtos");
            return;
        }

        if (this.tipoTransacao.equalsIgnoreCase("serviço") && (imposto.equalsIgnoreCase("ICMS") || imposto.equalsIgnoreCase("IPI"))) {
            System.out.println("Erro: Icms e IPI nao se adiciona a servicos");
            return;
        }

        double valorImpostos = 0.0;
        double baseCalculo = this.preco + this.frete + this.seguro;

        // tipo de imposto
        switch (imposto.toUpperCase()) {
            case "IPI":
                valorImpostos = baseCalculo * 0.015; // IPI = 1.5%
                break;
            case "ICMS":
                valorImpostos = this.preco * 0.12; // ICMS = 12%
                break;
                // a tratar quando muda o estado
            case "ISS":
                valorImpostos = this.preco * 0.20; // ISS = 20%
                break;
            default:
                System.out.println("Erro: Tipo de imposto inválido!");
                return;
        }

        // preço total considerando impostos e margem de lucro
        double valorMargemLucro = (this.margemLucro / 100.0) * this.preco;
        double precoFinal = this.preco + valorImpostos + valorMargemLucro;

        // exicao no console do cadastro
        System.out.printf("Base de Cálculo (Produto + Frete + Seguro): R$ %.2f%n", baseCalculo);
        System.out.printf("Impostos (%s): R$ %.2f%n", imposto, valorImpostos);
        System.out.printf("Margem de Lucro (%d%%): R$ %.2f%n", this.margemLucro, valorMargemLucro);
        System.out.printf("Preço Final com %s: R$ %.2f%n", imposto, precoFinal);
        System.out.println("-------------------------------------");
    }
}
