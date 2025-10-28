package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record CarteiraDTO(
        Integer id,
        @NotBlank String nome,
        @NotNull LocalDate dataCriacao,
        List<PosicaoDTO> posicoes
) {}
