package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.TransacaoDTO;
import sc302072x.entity.Transacao;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    @Mapping(source = "ativo.ticker", target = "ativoTicker")
    TransacaoDTO toDTO(Transacao entity);

    @Mapping(target = "ativo", ignore = true)
    Transacao toEntity(TransacaoDTO dto);
}
