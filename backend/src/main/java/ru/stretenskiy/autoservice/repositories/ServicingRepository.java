package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.utils.CostServices;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServicingRepository extends JpaRepository<Servicing, Long> {

    @Query(value = "SELECT * FROM services p ORDER BY id", nativeQuery = true)
    Page<Car> loadListOfServices(Pageable pageable);

    @Query(value = "SELECT cost_our AS costOur, cost_foreign AS costForeign FROM find_cost_services(?1, ?2)", nativeQuery = true)
    Optional<CostServices> getSumCost(Date withDate, Date beforeDate);

}
