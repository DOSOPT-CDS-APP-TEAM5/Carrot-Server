package CarrotServer.controller.response;

import CarrotServer.domain.Albums;
import CarrotServer.domain.ClubCategory;
import CarrotServer.domain.Clubs;

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
    public static ClubGetResponse of(Clubs clubs) {
        return new ClubGetResponse(
                clubs.getClubName(),
                clubs.getClubImg(),
                clubs.getClubBackgroundImg(),
                clubs.getClubCategory(),
                clubs.getParticipantCount(),
                clubs.getClubContent(),
                clubs.getAlbums()
                        .stream()
                        .map(AlbumGetResposne::of) // AlbumResponse.of 메서드를 활용하여 Albums를 AlbumResponse로 변환
                        .collect(Collectors.toList())
        );
    }
}
