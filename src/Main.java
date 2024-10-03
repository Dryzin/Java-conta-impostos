public class Main {
    public static void main(String[] args) {
        NotaFiscal produto1 = new NotaFiscal(150.0, 30.0, 20.0, 10, "produto");
        produto1.calcularPrecoFinal("ICMS");

        NotaFiscal servico1 = new NotaFiscal(200.0, 0.0, 0.0, 15, "serviço");
        servico1.calcularPrecoFinal("ISS");

        NotaFiscal produto2 = new NotaFiscal(300.0, 50.0, 10.0, 20, "produto");
        produto2.calcularPrecoFinal("IPI");

        NotaFiscal produto3 = new NotaFiscal(100.0, 20.0, 15.0, 8, "produto");
        produto3.calcularPrecoFinal("ISS"); // mostra erro

        NotaFiscal servico2 = new NotaFiscal(500.0, 0.0, 0.0, 12, "serviço");
        servico2.calcularPrecoFinal("ICMS"); // mostra erro
    }
}