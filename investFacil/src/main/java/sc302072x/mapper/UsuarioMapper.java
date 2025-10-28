package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.UsuarioDTO;
import sc302072x.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario entity);
    @Mapping(target = "carteiras", ignore = true)
    Usuario toEntity(UsuarioDTO dto);
}
