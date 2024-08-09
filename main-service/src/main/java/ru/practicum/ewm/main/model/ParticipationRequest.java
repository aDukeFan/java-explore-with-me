package ru.practicum.ewm.main.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Entity
@Table(name = "requests", schema = "public")
public class ParticipationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_date")
    LocalDateTime created;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    Event event;
    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    User requester;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    State status;
}
