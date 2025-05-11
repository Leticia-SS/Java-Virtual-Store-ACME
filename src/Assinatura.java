import java.math.BigDecimal;
import java.time.LocalDate;

public class Assinatura {
    private BigDecimal mensalidade;
    private LocalDate begin;
    private LocalDate end;
    private Cliente cliente;

    public Assinatura(BigDecimal mensalidade, LocalDate begin, Cliente cliente) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.cliente = cliente;
    }

    public Assinatura(BigDecimal mensalidade, LocalDate begin, LocalDate end, Cliente cliente) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.end = end;
        this.cliente = cliente;
    }


}
