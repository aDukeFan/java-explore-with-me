package ru.practicum.ewm.main.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
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
@Table(name = "events", schema = "public")
@EqualsAndHashCode
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "create_date")
    LocalDateTime createdOn;
    @Column(name = "event_date")
    LocalDateTime eventDate;
    @Column(name = "title")
    String title;
    @Column(name = "annotation")
    String annotation;
    @Column(name = "description")
    String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    State state;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Column(name = "confirmed_requests")
    int confirmedRequests;
    @Column(name = "participant_limit")
    int participantLimit;
    @Column(name = "paid")
    Boolean paid;
    @Column(name = "request_moderation")
    Boolean requestModeration;
    @Column(name = "views_count")
    int views;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    Location location;
}
