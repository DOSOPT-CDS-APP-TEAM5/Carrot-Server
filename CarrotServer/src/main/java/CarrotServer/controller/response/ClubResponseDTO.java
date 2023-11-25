package CarrotServer.controller.response;

public record ClubResponseDTO(Long clubId, String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town) {
    public static ClubResponseDTO of(Long clubId, String clubCategoryContent, String clubName, String clubImg, int participantCount, String participantsImg, String town) {
        return new ClubResponseDTO(clubId,clubCategoryContent, clubName, clubImg, participantCount, participantsImg, town);
    }
}
