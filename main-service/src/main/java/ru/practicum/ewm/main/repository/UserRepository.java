package ru.practicum.ewm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
