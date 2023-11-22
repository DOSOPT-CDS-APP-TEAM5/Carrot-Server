package CarrotServer.controller;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.controller.request.ProfileCreateRequest;
import CarrotServer.controller.response.ClubGetResponse;
import CarrotServer.exception.Success;
import CarrotServer.service.ClubService;
import CarrotServer.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {
    private static final String CUSTOM_CLUB_ID = "X-Club-Id";
    private final ClubService clubService;
    private final ProfileService profileService;

    // 우리동네 모임 상세 조회 (단건 조회)
    @GetMapping(value = "/{clubId}")
    public ApiResponse<ClubGetResponse> getClubInformation(@PathVariable Long clubId){
        return ApiResponse.success(Success.GET_CLUB_SUCCESS, clubService.getClubById(clubId));
    }

    // 모임 프로필 생성
    @PostMapping(value = "/profile")
    public ResponseEntity<Void> createProfile(@RequestHeader(CUSTOM_CLUB_ID) Long clubId, @RequestBody ProfileCreateRequest request){
        URI location = URI.create(profileService.create(request, clubId));
        return ResponseEntity.created(location).build();
    }
}
