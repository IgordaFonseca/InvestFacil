package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.RendaVariavelDTO;
import sc302072x.entity.RendaVariavel;

@Mapper(componentModel = "spring")
public interface RendaVariavelMapper {
    RendaVariavelDTO toDTO(RendaVariavel entity);

    @Mapping(target = "classeAtivo", ignore = true)
    RendaVariavel toEntity(RendaVariavelDTO dto);
}

