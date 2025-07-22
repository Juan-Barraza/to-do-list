package com.java.todolist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.todolist.models.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.id = :id")
    Optional<Task> findTaskById(Long id);

    boolean existsByTitle(String title);

    @Query("SELECT t FROM Task t ORDER BY t.id")
    List<Task> getAllTask();
}
