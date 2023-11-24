package CarrotServer.mapper;

import CarrotServer.controller.response.LifeListResponseDTO;
import CarrotServer.domain.Lives;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LifeMapper {
    LifeMapper INSTANCE = Mappers.getMapper(LifeMapper.class);

    @Mapping(target = "lifeCategoryContent", source = "lifeCategory.name")
    @Mapping(target = "contentInformation", expression = "java(buildContentInformation(life.getTown(), life.getCreatedAt(), life.getViewCount()))")
    LifeListResponseDTO toLifeListResponseDTO(Lives life);

    default String buildContentInformation(String town, LocalDateTime createdAt, int viewCount) {
        String timeDiff = calculateTimeDifference(createdAt);
        return town + " · " + timeDiff +" · "+ "조회 " + viewCount;
    }

    private String calculateTimeDifference(LocalDateTime createdAt) {
        LocalDateTime now = LocalDateTime.now();
        int yearDiff = now.getYear() - createdAt.getYear();
        int monthDiff = now.getMonthValue() - createdAt.getMonthValue();
        int dayDiff = now.getDayOfMonth() - createdAt.getDayOfMonth();
        int hourDiff = now.getHour() - createdAt.getHour();
        int minuteDiff = now.getMinute() - createdAt.getMinute();

        if (yearDiff > 0) {
            return yearDiff + "년 전";
        } else if (monthDiff > 0) {
            return monthDiff + "달 전";
        } else if (dayDiff > 0) {
            return dayDiff + "일 전";
        } else if (hourDiff > 0) {
            return hourDiff + "시간 전";
        } else {
            return minuteDiff + "분 전";
        }
    }

    List<LifeListResponseDTO> toLifeListResponseDTOList(List<Lives> lifeList);
}
