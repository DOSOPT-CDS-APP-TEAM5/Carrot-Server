package CarrotServer.repository;

import CarrotServer.domain.Clubs;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubJpaRepository extends JpaRepository<Clubs, Long> {
    default Clubs findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 모임입니다."));
    }
}
