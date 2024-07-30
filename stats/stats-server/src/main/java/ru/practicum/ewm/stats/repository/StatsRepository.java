package ru.practicum.ewm.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.stats.model.EndpointHit;

import java.time.LocalDateTime;

@Repository
public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    Integer countByUriAndTimestampBetween(String uri, LocalDateTime start, LocalDateTime end);

    Integer countDistinctIpByUriAndTimestampBetween(String uri, LocalDateTime start, LocalDateTime end);
}
