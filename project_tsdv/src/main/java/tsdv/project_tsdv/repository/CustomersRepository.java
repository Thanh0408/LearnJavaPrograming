package tsdv.project_tsdv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsdv.project_tsdv.entity.Customers;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    @Query("SELECT username FROM Customers username WHERE username.username = :username")
    List<Customers> findByNameContaining(String username);
}
