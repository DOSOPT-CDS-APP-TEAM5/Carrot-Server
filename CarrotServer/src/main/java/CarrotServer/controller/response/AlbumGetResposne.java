package CarrotServer.controller.response;

import CarrotServer.domain.Album;

public record AlbumGetResposne(
        String albumImg
) {
    public static AlbumGetResposne of(Album album){
        return new AlbumGetResposne(
                album.getAlbumImg()
        );
    }
}
