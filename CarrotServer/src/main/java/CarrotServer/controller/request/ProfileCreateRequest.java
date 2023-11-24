package CarrotServer.controller.request;

public record ProfileCreateRequest(
        String nickname,
        String information
) {}
