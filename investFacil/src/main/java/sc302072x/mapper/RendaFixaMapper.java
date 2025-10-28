package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.RendaFixaDTO;
import sc302072x.entity.RendaFixa;

@Mapper(componentModel = "spring")
public interface RendaFixaMapper {
    RendaFixaDTO toDTO(RendaFixa entity);

    @Mapping(target = "classeAtivo", ignore = true)
    RendaFixa toEntity(RendaFixaDTO dto);
}
