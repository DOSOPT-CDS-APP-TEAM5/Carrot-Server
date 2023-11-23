package CarrotServer.repository;

import CarrotServer.domain.LifeCategory;
import CarrotServer.domain.Lives;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifeJpaRepository extends JpaRepository<Lives, Long>{
    List<Lives> findAllByLifeCategory(LifeCategory lifeCategory);
    List<Lives> findAll();
}
