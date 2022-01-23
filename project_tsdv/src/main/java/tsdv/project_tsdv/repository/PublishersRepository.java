package tsdv.project_tsdv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsdv.project_tsdv.entity.Publishers;

import java.util.List;

public interface PublishersRepository extends JpaRepository<Publishers, Long> {
    @Query("SELECT name FROM Publishers name WHERE name.name LIKE %:name%")
    List<Publishers> findByUsernameContaining(String name);
}
