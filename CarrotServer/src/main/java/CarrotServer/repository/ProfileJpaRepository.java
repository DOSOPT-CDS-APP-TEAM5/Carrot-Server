package CarrotServer.repository;

import CarrotServer.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileJpaRepository extends JpaRepository<Profile, Long> {
}
