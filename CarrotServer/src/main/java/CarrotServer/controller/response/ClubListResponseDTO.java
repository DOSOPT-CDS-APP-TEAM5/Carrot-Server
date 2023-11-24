package CarrotServer.controller.response;

public record ClubListResponseDTO(Long clubId,String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town) {
    public static ClubListResponseDTO of(Long clubId,String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town) {
        return new ClubListResponseDTO(clubId,clubCategoryContent, clubName, clubImg, participantCount, participantsImg, town);
    }
}
