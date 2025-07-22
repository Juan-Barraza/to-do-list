package com.java.todolist.services.task;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.todolist.dto.task.TaskCreateDto;
import com.java.todolist.models.Task;
import com.java.todolist.models.User;
import com.java.todolist.repositories.ITaskRepository;
import com.java.todolist.repositories.IUserRepository;
import com.java.todolist.utils.Mapeo;
import com.java.todolist.utils.exeptions.BusinessException;
import com.java.todolist.utils.exeptions.ResourceNotFoundException;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.task.TaskListResponse;
import com.java.todolist.utils.reponse.task.TaskResponse;
import com.java.todolist.utils.validators.task.ValidatorTask;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final IUserRepository userRepo;
    private final Mapeo mapperTs;
    private final ValidatorTask validatorTask;

    public TaskService(ITaskRepository taskRepository, IUserRepository userRepo, Mapeo mapperTs, ValidatorTask validatorTask) {
        this.taskRepository = taskRepository;
        this.userRepo = userRepo;
        this.mapperTs = mapperTs;
        this.validatorTask = validatorTask;
    }

    @Override
    @Transactional
    public ApiResponse<TaskResponse> createTask(TaskCreateDto taskCreateDto) {
    
        validatorTask.validate(taskCreateDto);
        
        if (taskRepository.existsByTitle(taskCreateDto.getTitle())) {
            throw new BusinessException("Task already exist with this title");
        }
        User user = userRepo.findUserById(taskCreateDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User no found"));
        Task task = mapperTs.convertToEntity(taskCreateDto, Task.class);
        task.setUser(user);
        user.getTasks().add(task);
        taskRepository.save(task);

        TaskResponse taskResponse = mapperTs.convertToDto(task, TaskResponse.class);

        return ApiResponse.success(taskResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<TaskResponse> getTaskById(Long id) {
        Task task = taskRepository.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task no found"));
            TaskResponse taskResponse = mapperTs.convertToDto(task, TaskResponse.class);
        return ApiResponse.success(taskResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<TaskListResponse> getAllTask() {
        List<TaskResponse> taskResponse = taskRepository.getAllTask().stream()
                .map(task -> mapperTs.convertToDto(task, TaskResponse.class))
                .toList();
        TaskListResponse response = new TaskListResponse(taskResponse);

        return ApiResponse.success(response);
    }
}
