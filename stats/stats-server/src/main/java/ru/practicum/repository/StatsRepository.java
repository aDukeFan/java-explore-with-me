package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.model.EndpointHit;

import java.time.LocalDateTime;

@Repository
public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    Integer countByUriAndTimestampBetween(String uri, LocalDateTime start, LocalDateTime end);

    Integer countIpByUriAndTimestampBetween(String uri, LocalDateTime start, LocalDateTime end);
}
