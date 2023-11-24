package CarrotServer.repository;

import CarrotServer.common.enums.LifeCategory;
import CarrotServer.domain.Life;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifeJpaRepository extends JpaRepository<Life, Long>{
    List<Life> findAllByLifeCategory(LifeCategory lifeCategory);
    List<Life> findAll();
}
