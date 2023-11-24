package CarrotServer.controller.response;

public record ClubListResponseDTO(Long clubId,String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town, int commentCount) {
    public static ClubListResponseDTO of(Long clubId,String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town, int commentCount) {
        return new ClubListResponseDTO(clubId,clubCategoryContent, clubName, clubImg, participantCount, participantsImg, town, commentCount);
    }
}
