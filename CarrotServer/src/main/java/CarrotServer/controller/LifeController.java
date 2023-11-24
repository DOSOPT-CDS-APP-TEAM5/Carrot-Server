package CarrotServer.controller;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.controller.response.LifeListResponseDTO;
import CarrotServer.domain.LifeCategory;
import CarrotServer.exception.Error;
import CarrotServer.exception.Success;
import CarrotServer.service.LifeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lives")
public class LifeController {
    private final LifeService lifeService;

    @GetMapping("")
    public ApiResponse<List<LifeListResponseDTO>> getLifeList(@RequestParam(name = "category", required = false) String category){
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
