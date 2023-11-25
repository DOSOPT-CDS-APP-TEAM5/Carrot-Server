package CarrotServer.service;

import CarrotServer.controller.request.ProfileRequestDTO;
import CarrotServer.domain.Club;
import CarrotServer.domain.Profile;
import CarrotServer.repository.ClubJpaRepository;
import CarrotServer.repository.ProfileJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {

    private final ProfileJpaRepository profileJpaRepository;
    private final ClubJpaRepository clubJpaRepository;

    @Transactional
    public String create(ProfileRequestDTO request, Long clubId) {
        Club club = clubJpaRepository.findByIdOrThrow(clubId);
        Profile profile = profileJpaRepository.save(Profile.builder()
                .club(club)
                .nickname(request.nickname())
                .information(request.information())
                .build());
        return profile.getProfileId().toString();
    }
}
