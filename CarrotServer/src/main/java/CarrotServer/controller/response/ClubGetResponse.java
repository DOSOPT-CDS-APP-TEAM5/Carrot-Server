package CarrotServer.controller.response;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.domain.Club;

import java.util.List;
import java.util.stream.Collectors;

public record ClubGetResponse(
        String clubName,
        String clubImg,
        String clubBackgroundImg,
        ClubCategory clubCategory,
        Integer participantCount,
        String clubContent,
        List<AlbumGetResposne> albums
) {
    public static ClubGetResponse of(Club club) {
        return new ClubGetResponse(
                club.getClubName(),
                club.getClubImg(),
                club.getClubBackgroundImg(),
                club.getClubCategory(),
                club.getParticipantCount(),
                club.getClubContent(),
                club.getAlbums()
                        .stream()
                        .map(AlbumGetResposne::of) // AlbumResponse.of 메서드를 활용하여 Albums를 AlbumResponse로 변환
                        .collect(Collectors.toList())
        );
    }
}
