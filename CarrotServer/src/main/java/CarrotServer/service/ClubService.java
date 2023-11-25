package CarrotServer.service;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.controller.response.ClubDetailResponseDTO;
import CarrotServer.controller.response.ClubResponseDTO;
import CarrotServer.domain.Club;
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

    public ClubDetailResponseDTO getClubById(Long id) {
        return ClubDetailResponseDTO.of(clubJpaRepository.findByIdOrThrow(id));
    }

    public List<ClubResponseDTO> getClubList() {
        List<Club> clubList = clubJpaRepository.findAll();
        return ClubMapper.INSTANCE.toClubListResponseDTOList(clubList);
    }

    public List<ClubResponseDTO> getClubListFilteredByClubCategory(ClubCategory clubCategory) {
        List<Club> clubList = clubJpaRepository.findAllByClubCategory(clubCategory);
        return ClubMapper.INSTANCE.toClubListResponseDTOList(clubList);
    }
}
