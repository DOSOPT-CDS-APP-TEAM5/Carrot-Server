package CarrotServer.controller;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.controller.response.LifeResponseDTO;
import CarrotServer.common.enums.LifeCategory;
import CarrotServer.exception.Error;
import CarrotServer.exception.Success;
import CarrotServer.service.LifeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lives")
@Tag(name = "life", description = "우리동네 생활 정보 관련 API")
public class LifeController {
    private final LifeService lifeService;

    @Operation(summary = "우리동네 생활 정보 리스트 조회", description = "우리동네 생활 정보 리스트를 조회합니다.")
    @GetMapping("")
    public ApiResponse<List<LifeResponseDTO>> getLifeList(@RequestParam(name = "category", required = false) String category){
        if(category == null){
            return ApiResponse.success(Success.GET_TOWN_LIVES_SUCCESS,lifeService.getLifeList());
        }
        LifeCategory lifeCategory = LifeCategory.findByName(category);
        if(lifeCategory == null){
            return ApiResponse.error(Error.NOT_FOUND_CATEGORY);
        }
        return ApiResponse.success(Success.GET_FILTERED_TOWN_LIVES_SUCCESS,lifeService.getLifeListFilteredByLifeCategory(lifeCategory));
    }
}
