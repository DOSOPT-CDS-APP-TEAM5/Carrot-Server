package CarrotServer.service;

import CarrotServer.controller.response.ClubGetResponse;
import CarrotServer.repository.ClubJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {
    private final ClubJpaRepository clubJpaRepository;

    public ClubGetResponse getClubById(Long id) {
        return ClubGetResponse.of(clubJpaRepository.findByIdOrThrow(id));
    }
}
