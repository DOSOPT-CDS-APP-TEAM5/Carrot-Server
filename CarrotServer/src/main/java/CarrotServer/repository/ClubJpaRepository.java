package CarrotServer.repository;

import CarrotServer.common.enums.ClubCategory;
import CarrotServer.domain.Clubs;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubJpaRepository extends JpaRepository<Clubs, Long> {
    default Clubs findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 모임입니다."));
    }

    List<Clubs> findAll();
    List<Clubs> findAllByClubCategory(ClubCategory category);
}
