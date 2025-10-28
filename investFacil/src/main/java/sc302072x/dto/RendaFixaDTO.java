package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record RendaFixaDTO(
        @NotBlank String ticker,
        @NotBlank String nome,
        @NotNull Integer classeId,
        @PositiveOrZero float taxa,
        @NotNull LocalDate vencimento,
        @NotBlank String indexador
) {}
