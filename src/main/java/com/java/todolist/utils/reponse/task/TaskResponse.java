package com.java.todolist.utils.reponse.task;

import java.time.LocalDateTime;


public class TaskResponse {
    private Long idTask;
    private String title;
    private LocalDateTime deuDate;
    private boolean isCompleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    public TaskResponse() {
    }

    public TaskResponse(Long idTask, String title, LocalDateTime deuDate, boolean isCompleted, LocalDateTime createdAt,
            LocalDateTime updatedAt, Long Iduser) {
        this.idTask = idTask;
        this.title = title;
        this.deuDate = deuDate;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = Iduser;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDeuDate() {
        return deuDate;
    }

    public void setDeuDate(LocalDateTime deuDate) {
        this.deuDate = deuDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}