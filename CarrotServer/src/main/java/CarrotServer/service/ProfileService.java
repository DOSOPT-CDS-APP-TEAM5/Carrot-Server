package CarrotServer.service;

import CarrotServer.controller.request.ProfileCreateRequest;
import CarrotServer.domain.Clubs;
import CarrotServer.domain.Profiles;
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
    public String create(ProfileCreateRequest request, Long clubId) {
        Clubs clubs = clubJpaRepository.findByIdOrThrow(clubId);
        Profiles profiles = profileJpaRepository.save(Profiles.builder()
                .club(clubs)
                .nickname(request.nickname())
                .information(request.information())
                .build());
        return profiles.getProfileId().toString();
    }
}
