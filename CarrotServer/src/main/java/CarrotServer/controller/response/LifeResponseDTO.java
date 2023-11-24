package CarrotServer.controller.response;

public record LifeResponseDTO(Long lifeId, String lifeCategoryContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
    public static LifeResponseDTO of(Long lifeId, String lifeCategoryContent, String lifeTitle, String lifeContent, String contentInformation, int likeCount, int commentCount){
        return new LifeResponseDTO(lifeId, lifeCategoryContent, lifeTitle, lifeContent, contentInformation, likeCount, commentCount);
    }
}

