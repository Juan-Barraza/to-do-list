package com.java.todolist.controllers.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.todolist.controllers.BaseController;
import com.java.todolist.dto.task.TaskCreateDto;
import com.java.todolist.services.task.ITaskService;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.task.TaskListResponse;
import com.java.todolist.utils.reponse.task.TaskResponse;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController extends BaseController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskCreateDto taskCreateDto) {
        ApiResponse<TaskResponse> response = taskService.createTask(taskCreateDto);
        return createdResponse(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        ApiResponse<TaskResponse> response = taskService.getTaskById(id);
        return successResponse(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllTask() {
        ApiResponse<TaskListResponse> response = taskService.getAllTask();
        return successResponse(response);
    }

}
