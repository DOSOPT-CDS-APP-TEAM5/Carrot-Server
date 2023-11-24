package CarrotServer.repository;

import CarrotServer.domain.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileJpaRepository extends JpaRepository<Profiles, Long> {
}
