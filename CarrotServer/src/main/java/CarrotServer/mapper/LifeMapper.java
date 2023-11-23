package CarrotServer.mapper;

import CarrotServer.controller.response.LifeListResponseDTO;
import CarrotServer.domain.Lives;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LifeMapper {
    LifeMapper INSTANCE = Mappers.getMapper(LifeMapper.class);

    List<LifeListResponseDTO> toLifeListResponseDTOList(List<Lives> lifeList);
}
