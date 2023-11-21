package CarrotServer.controller;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.controller.response.ClubGetResponse;
import CarrotServer.exception.Success;
import CarrotServer.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    // 우리동네 모임 상세 조회 (단건 조회)
    @GetMapping(value = "/{clubId}")
    public ApiResponse<ClubGetResponse> getClubInformation(@PathVariable Long clubId){
        return ApiResponse.success(Success.GET_CLUB_SUCCESS, clubService.getClubById(clubId));
    }
}
