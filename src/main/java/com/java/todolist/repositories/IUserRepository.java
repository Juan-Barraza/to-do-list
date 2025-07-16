package com.java.todolist.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.java.todolist.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findUserById(Long id);
    
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
    @Query("SELECT u FROM User u ORDER BY u.id")
    List<User> findAllUsers();
}