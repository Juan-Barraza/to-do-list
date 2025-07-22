package com.java.todolist.services.task;

import com.java.todolist.dto.task.TaskCreateDto;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.task.TaskListResponse;
import com.java.todolist.utils.reponse.task.TaskResponse;

public interface ITaskService {
    public ApiResponse<TaskResponse> createTask(TaskCreateDto taskCreateDto);
    public ApiResponse<TaskResponse> getTaskById(Long id);
    public ApiResponse<TaskListResponse> getAllTask();
}
