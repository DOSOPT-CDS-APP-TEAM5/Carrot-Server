package CarrotServer.controller.response;

public record LifeListResponseDTO(Long lifeId, String lifeTagContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
    public static LifeListResponseDTO of(Long lifeId, String lifeTagContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
        return new LifeListResponseDTO(lifeId, lifeTagContent, lifeTitle, lifeContent, contentInformation, likeCount, commentCount);
    }
}

