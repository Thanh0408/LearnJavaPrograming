package tsdv.project_tsdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsdv.project_tsdv.entity.Categories;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    @Query("SELECT name FROM Categories name WHERE name.name LIKE %:name%")
    List<Categories> findByUsernameContaining(String name);
}
