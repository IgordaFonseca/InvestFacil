package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record PosicaoDTO(
        Integer id,
        @NotBlank String ativoTicker,
        @PositiveOrZero int quantidade,
        LocalDate dataCompra,
        List<TransacaoDTO> transacoes,
        List<DividendoDTO> dividendos
) {}
