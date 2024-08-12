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

    @Query("SELECT e FROM Event e WHERE e.date >= :currentDate")
    Page<Event> findUpcomingEvents(@Param("currentDate") Date currentDate, Pageable pageable);
}
