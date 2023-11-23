package CarrotServer.controller.response;

public record LifeListResponseDTO(Long lifeId, String lifeCategoryContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
    public static LifeListResponseDTO of(Long lifeId, String lifeCategoryContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
        return new LifeListResponseDTO(lifeId, lifeCategoryContent, lifeTitle, lifeContent, contentInformation, likeCount, commentCount);
    }
}

