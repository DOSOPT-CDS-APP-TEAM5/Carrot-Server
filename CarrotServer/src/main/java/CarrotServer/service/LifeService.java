package CarrotServer.service;

import CarrotServer.controller.response.LifeListResponseDTO;
import CarrotServer.common.enums.LifeCategory;
import CarrotServer.domain.Life;
import CarrotServer.mapper.LifeMapper;
import CarrotServer.repository.LifeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LifeService {
    private final LifeJpaRepository lifeJpaRepository;

    public List<LifeListResponseDTO> getLifeListFilteredByLifeCategory(LifeCategory lifeCategory){
        List<Life> lifeList = lifeJpaRepository.findAllByLifeCategory(lifeCategory);
        return LifeMapper.INSTANCE.toLifeListResponseDTOList(lifeList);
    }

    public List<LifeListResponseDTO> getLifeList(){
        List<Life> lifeList = lifeJpaRepository.findAll();
        return LifeMapper.INSTANCE.toLifeListResponseDTOList(lifeList);
    }
}
