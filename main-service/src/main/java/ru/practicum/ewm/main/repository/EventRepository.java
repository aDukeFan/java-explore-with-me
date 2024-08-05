package ru.practicum.ewm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.main.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
