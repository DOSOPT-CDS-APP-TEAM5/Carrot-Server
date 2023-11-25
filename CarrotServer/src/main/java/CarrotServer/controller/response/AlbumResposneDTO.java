package CarrotServer.controller.response;

import CarrotServer.domain.Album;

public record AlbumResposneDTO(
        String albumImg
) {
    public static AlbumResposneDTO of(Album album){
        return new AlbumResposneDTO(
                album.getAlbumImg()
        );
    }
}
