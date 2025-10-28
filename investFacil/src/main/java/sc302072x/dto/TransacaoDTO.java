package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record TransacaoDTO(
        Integer id,
        @NotBlank String tipo,
        @NotNull LocalDate data,
        @Positive int quantidade,
        @PositiveOrZero float precoUnitario,
        @PositiveOrZero float taxa,
        @PositiveOrZero float precoTotal,
        @NotBlank String ativoTicker
) {}

