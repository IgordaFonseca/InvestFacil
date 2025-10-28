package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record DividendoDTO(
        Integer id,
        @NotNull LocalDate dataCom,
        LocalDate dataPagamento,
        @PositiveOrZero float valorPago
) {}

