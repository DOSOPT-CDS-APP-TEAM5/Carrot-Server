package CarrotServer.controller;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.common.enums.LifeCategory;
import CarrotServer.common.response.ApiResponse;
import CarrotServer.controller.request.ProfileCreateRequest;
import CarrotServer.controller.response.ClubGetResponse;
import CarrotServer.controller.response.ClubListResponseDTO;
import CarrotServer.exception.Error;
import CarrotServer.exception.Success;
import CarrotServer.service.ClubService;
import CarrotServer.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {

    private static final String CUSTOM_CLUB_ID = "X-Club-Id";
    private final ClubService clubService;
    private final ProfileService profileService;

    // 우리동네 모임 상세 조회 (단건 조회)
    @Operation(summary = "우리동네 모임 상세 조회", description = "모임 상세 정보를 조회합니다.", tags = { "Club Controller" })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(value = "/{clubId}")
    public ApiResponse<ClubGetResponse> getClubInformation(@PathVariable Long clubId){
        return ApiResponse.success(Success.GET_CLUB_SUCCESS, clubService.getClubById(clubId));
    }

    // 모임 프로필 생성
    @Operation(summary = "모임 프로필 생성", description = "모임에서 사용할 프로필을 생성합니다.", tags = { "Club Controller" })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping(value = "/profile")
    public ApiResponse<Void> createProfile(@RequestHeader(CUSTOM_CLUB_ID) Long clubId, @RequestBody ProfileCreateRequest request){
        URI location = URI.create(profileService.create(request, clubId));
        return ApiResponse.success(Success.CREATE_PROFILE_SUCCESS);
    }

    @Operation(summary = "우리동네 모임 카테고리 별 조회", description = "카테고리에 맞는 모임들을 조회합니다.", tags = { "Club Controller" })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("")
    public ApiResponse<List<ClubListResponseDTO>> getClubList(@RequestParam(name = "category", required = false) String category){
        if(category == null){
            return ApiResponse.success(Success.GET_TOWN_CLUBS_SUCCESS,clubService.getClubList());
        }
        ClubCategory clubCategory = ClubCategory.findByName(category);
        if(clubCategory == null){
            return ApiResponse.error(Error.NOT_FOUND_CATEGORY);
        }
        return ApiResponse.success(Success.GET_FILTERED_TOWN_CLUBS_SUCCESS,clubService.getClubListFilteredByClubCategory(clubCategory));
    }
}