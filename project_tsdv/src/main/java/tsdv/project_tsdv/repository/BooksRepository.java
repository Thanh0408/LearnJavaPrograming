package tsdv.project_tsdv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsdv.project_tsdv.entity.Books;

import java.util.List;


public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query("SELECT name FROM Books name WHERE name.name LIKE %:name%")
    List<Books> findByUsernameContaining(String name);
}
