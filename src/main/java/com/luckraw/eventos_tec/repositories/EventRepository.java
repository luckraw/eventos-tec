package com.luckraw.eventos_tec.repositories;

import com.luckraw.eventos_tec.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e LEFT JOIN FETCH e.address a WHERE e.date >= :currentDate")
    Page<Event> findUpcomingEvents(@Param("currentDate") Date currentDate, Pageable pageable);

    @Query("SELECT e FROM Event e LEFT JOIN e.address a " +
            "WHERE (:title IS NULL OR e.title LIKE CONCAT('%', :title, '%')) " +
            "AND (:city IS NULL OR a.city LIKE CONCAT('%', :city, '%')) " +
            "AND (:uf IS NULL OR a.uf LIKE CONCAT('%', :uf, '%')) " +
            "AND (:startDate IS NULL OR e.date >= :startDate) " +
            "AND (:endDate IS NULL OR e.date <= :endDate)")
    Page<Event> findFilteredEvents(@Param("title") String title,
                                   @Param("city") String city,
                                   @Param("uf") String uf,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   Pageable pageable);

}
