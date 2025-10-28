package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.DividendoDTO;
import sc302072x.entity.Dividendo;

@Mapper(componentModel = "spring")
public interface DividendoMapper {
    DividendoDTO toDTO(Dividendo entity);
    Dividendo toEntity(DividendoDTO dto);
}
