package ru.rt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Boolean existsUserByEmail(String email);

}
