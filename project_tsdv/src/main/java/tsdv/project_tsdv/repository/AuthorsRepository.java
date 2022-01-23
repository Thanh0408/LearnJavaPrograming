package tsdv.project_tsdv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsdv.project_tsdv.entity.Authors;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    @Query("SELECT name FROM Authors name WHERE name.name LIKE %:name%")
    List<Authors> findByUsernameContaining(String name);
}
