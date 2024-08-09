package ru.practicum.ewm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.main.model.ParticipationRequest;

import java.util.List;

@Repository
public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Integer> {
    ParticipationRequest findByIdAndRequesterId(Integer requestId, Integer userId);

    List<ParticipationRequest> findByRequesterId(Integer userId);

    List<ParticipationRequest> findByEventId(Integer eventId);
}
