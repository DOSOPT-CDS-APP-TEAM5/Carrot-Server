package CarrotServer.repository;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.domain.Club;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubJpaRepository extends JpaRepository<Club, Long> {
    default Club findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 모임입니다."));
    }

    List<Club> findAll();
    List<Club> findAllByClubCategory(ClubCategory clubCategory);
}
