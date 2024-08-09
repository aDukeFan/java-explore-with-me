package ru.practicum.ewm.main.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.main.model.Event;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Boolean existsByIdAndUserId(Integer eventId, Integer userId);

    Event findByIdAndUserId(Integer eventId, Integer userId);

    List<Event> findAllByUserId(Integer userId, Pageable pageable);
}
