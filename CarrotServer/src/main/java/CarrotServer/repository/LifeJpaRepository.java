package CarrotServer.repository;

import CarrotServer.domain.Lives;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifeJpaRepository extends JpaRepository<Lives, Long>{
    List<Lives> findAllByLifeCategory(String lifeCategory);
    List<Lives> findAll();
}
