package ru.practicum.ewm.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.stats.model.EndpointHit;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    Integer countByAppAndUriAndTimestampBetween(String app,
                                                String uri,
                                                LocalDateTime start,
                                                LocalDateTime end);

    @Query(value = "SELECT COUNT(DISTINCT ip) FROM statistics " +
            "WHERE app = ? AND uri = ? AND event_time  BETWEEN ? AND ?", nativeQuery = true)
    Integer countUniqueIpByAppAndUriAndTimestampBetween(String app,
                                                        String uri,
                                                        LocalDateTime start,
                                                        LocalDateTime end);

    @Query(value = "SELECT DISTINCT uri FROM statistics " +
            "WHERE app = ? AND event_time BETWEEN ? AND ?", nativeQuery = true)
    List<String> findAllUriByAppAndTimestampBetween(String app,
                                                    LocalDateTime start,
                                                    LocalDateTime end);
}
