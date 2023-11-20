package CarrotServer.controller.response;

import CarrotServer.domain.Albums;

public record AlbumGetResposne(
        String albumImg
) {
    public static AlbumGetResposne of(Albums albums){
        return new AlbumGetResposne(
                albums.getAlbumImg()
        );
    }
}
