package sc302072x.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public record UsuarioDTO(
        @NotBlank String cpf,
        @NotBlank @Size(max = 100) String nome,
        @Email @NotBlank String email,
        @NotBlank @Size(min = 6) String senha,
        List<CarteiraDTO> carteiras
) {}
