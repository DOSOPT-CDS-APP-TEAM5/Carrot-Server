package CarrotServer.controller.response;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.domain.Club;

import java.util.List;
import java.util.stream.Collectors;

public record ClubDetailResponseDTO(
        String clubName,
        String clubImg,
        String clubBackgroundImg,
        ClubCategory clubCategory,
        Integer participantCount,
        String clubContent,
        List<AlbumResposneDTO> albums
) {
    public static ClubDetailResponseDTO of(Club club) {
        return new ClubDetailResponseDTO(
                club.getClubName(),
                club.getClubImg(),
                club.getClubBackgroundImg(),
                club.getClubCategory(),
                club.getParticipantCount(),
                club.getClubContent(),
                club.getAlbums()
                        .stream()
                        .map(AlbumResposneDTO::of) // AlbumResponse.of 메서드를 활용하여 Albums를 AlbumResponse로 변환
                        .collect(Collectors.toList())
        );
    }
}
