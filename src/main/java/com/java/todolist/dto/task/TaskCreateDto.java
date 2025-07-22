package com.java.todolist.dto.task;

import java.time.LocalDate;

public class TaskCreateDto {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long userId;

    public TaskCreateDto() {
    }

    public TaskCreateDto(String title, String description, LocalDate dueDate, Long userId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
