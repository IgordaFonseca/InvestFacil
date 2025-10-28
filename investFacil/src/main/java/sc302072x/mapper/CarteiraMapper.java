package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.CarteiraDTO;
import sc302072x.entity.Carteira;

@Mapper(componentModel = "spring")
public interface CarteiraMapper {
    CarteiraDTO toDTO(Carteira entity);
    @Mapping(target = "posicoes", ignore = true)
    Carteira toEntity(CarteiraDTO dto);
}
