package CarrotServer.service;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.controller.response.ClubGetResponse;
import CarrotServer.controller.response.ClubListResponseDTO;
import CarrotServer.domain.Clubs;
import CarrotServer.mapper.ClubMapper;
import CarrotServer.repository.ClubJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {
    private final ClubJpaRepository clubJpaRepository;

    public ClubGetResponse getClubById(Long id) {
        return ClubGetResponse.of(clubJpaRepository.findByIdOrThrow(id));
    }

    public List<ClubListResponseDTO> getClubList() {
        List<Clubs> clubList = clubJpaRepository.findAll();
        return ClubMapper.INSTANCE.toClubListResponseDTOList(clubList);
    }

    public List<ClubListResponseDTO> getClubListFilteredByClubCategory(ClubCategory clubCategory) {
        List<Clubs> clubList = clubJpaRepository.findAllByClubCategory(clubCategory);
        return ClubMapper.INSTANCE.toClubListResponseDTOList(clubList);
    }
}
