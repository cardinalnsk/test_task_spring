package ru.cardinal.testtask.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cardinal.testtask.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long id);
}
