package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.ClasseAtivoDTO;
import sc302072x.entity.ClasseAtivo;

@Mapper(componentModel = "spring")
public interface ClasseAtivoMapper {
    ClasseAtivoDTO toDTO(ClasseAtivo entity);
    ClasseAtivo toEntity(ClasseAtivoDTO dto);
}
