import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = criarProdutos();
        List<Cliente> clientes = criarClientes();
        List<Pagamento> pagamentos = criarPagamentos(produtos, clientes);

        System.out.println("====== Pagamentos por data ======\n");

        // Ordenando pagamwntos por data e printando com nome e valor total
        pagamentos.stream().sorted(Comparator.comparing(Pagamento::getDataCompra))
                .forEach(p -> System.out.println(p.getDataCompra() + " | " + p.getCliente().getNome() + " | " + "R$" + p.getValorTotal()));

    }

    private static List<Produto> criarProdutos() {
        return Arrays.asList(
                new Produto("Música 1", Paths.get("/musicas/1.mp3"), new BigDecimal("9.99")),
                new Produto("Música 2", Paths.get("/musicas/2.mp3"), new BigDecimal("12.99")),
                new Produto("Vídeo 1", Paths.get("/videos/1.mp4"), new BigDecimal("29.99")),
                new Produto("Vídeo 2", Paths.get("/videos/2.mp4"), new BigDecimal("39.99")),
                new Produto("Imagem 1", Paths.get("/imagens/1.jpg"), new BigDecimal("5.99")),
                new Produto("Imagem 2", Paths.get("/imagens/2.jpg"), new BigDecimal("7.99"))
        );
    }

    private static List<Cliente> criarClientes() {
        return Arrays.asList(
                new Cliente("Lara Saraiva"),
                new Cliente("Hugo Moura"),
                new Cliente("Dimitri Balby"),
                new Cliente("Steph Grizotti")

        );
    }

    private static List<Pagamento> criarPagamentos(List<Produto> produtos, List<Cliente> clientes) {
        return Arrays.asList(
                new Pagamento(Arrays.asList(produtos.get(0), produtos.get(2),produtos.get(4)), LocalDate.now(), clientes.get(0)),
                new Pagamento(Arrays.asList(produtos.get(1), produtos.get(3)), LocalDate.now().minusDays(1), clientes.get(2)),
                new Pagamento(Arrays.asList(produtos.get(0), produtos.get(1), produtos.get(5)), LocalDate.now().minusMonths(1), clientes.get(1)),
                new Pagamento(Arrays.asList(produtos.get(3), produtos.get(4)), LocalDate.now().minusDays(3), clientes.get(3))
        );
    }

    private static List<Assinatura> criarAssinatura(List<Cliente> clientes) {
        return Arrays.asList(
                new Assinatura(new BigDecimal("99.98"),LocalDate.now().minusMonths(6), clientes.get(1)),
                new Assinatura(new BigDecimal("99.98"),LocalDate.now().minusYears(1),LocalDate.now().minusMonths(1),clientes.get(0)),
                new Assinatura(new BigDecimal("99.98"),LocalDate.now().minusMonths(10),LocalDate.now().minusMonths(3),clientes.get(3))
        );
    }

}