package CarrotServer.controller.request;

import CarrotServer.controller.response.AlbumGetResposne;
import CarrotServer.domain.Albums;
import CarrotServer.domain.Profiles;

public record ProfileCreateRequest(
        String nickname,
        String information
) {}
