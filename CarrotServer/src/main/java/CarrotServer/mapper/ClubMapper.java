package CarrotServer.mapper;

import CarrotServer.controller.response.ClubListResponseDTO;
import CarrotServer.domain.Clubs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClubMapper {
    ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);

    @Mapping(target = "clubCategoryContent", source = "clubCategory.name")
    ClubListResponseDTO toClubListResponseDTO(Clubs club);

    List<ClubListResponseDTO> toClubListResponseDTOList(List<Clubs> clubList);

}
