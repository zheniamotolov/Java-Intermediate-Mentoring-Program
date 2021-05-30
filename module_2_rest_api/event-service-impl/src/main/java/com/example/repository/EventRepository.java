package com.example.repository;

import com.example.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select u from Event u where u.title = ?1")
    List<Event> findAllByTitle(String title);
}
