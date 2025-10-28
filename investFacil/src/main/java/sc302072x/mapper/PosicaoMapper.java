package sc302072x.mapper;

import org.mapstruct.*;
import sc302072x.dto.PosicaoDTO;
import sc302072x.entity.Posicao;

@Mapper(componentModel = "spring")
public interface PosicaoMapper {
    @Mapping(source = "ativo.ticker", target = "ativoTicker")
    PosicaoDTO toDTO(Posicao entity);

    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "transacoes", ignore = true)
    @Mapping(target = "dividendos", ignore = true)
    Posicao toEntity(PosicaoDTO dto);
}
