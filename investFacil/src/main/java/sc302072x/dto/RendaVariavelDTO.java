package sc302072x.dto;

import jakarta.validation.constraints.*;

public record RendaVariavelDTO(
        @NotBlank String ticker,
        @NotBlank String nome,
        @NotNull Integer classeId,
        @NotBlank String setor,
        @NotBlank String bolsa,
        @PositiveOrZero float valorAtual
) {}
