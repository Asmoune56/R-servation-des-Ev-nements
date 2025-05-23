package com.Reservation.evenements.repository;

import com.Reservation.evenements.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.util.List;
@Repository

public interface EventRepository extends JpaRepository<Evenement, Long> {

    @Query(value = "select", nativeQuery = true)
    List<Result> findBy(Long id);

}
