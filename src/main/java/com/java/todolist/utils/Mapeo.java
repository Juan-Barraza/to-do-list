package com.java.todolist.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.java.todolist.dto.task.TaskCreateDto;
import com.java.todolist.dto.task.TaskUpdateDto;
import com.java.todolist.dto.user.UserDto;
import com.java.todolist.models.Task;
import com.java.todolist.models.User;
import com.java.todolist.utils.reponse.task.TaskResponse;

@Component
public class Mapeo {

    private final ModelMapper modelMapper;

    public Mapeo(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        try {
            configureMappings();
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure ModelMapper", e);
        }
    }

    private void configureMappings() {
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        TypeMap<UserDto, User> userDtoMap = modelMapper.createTypeMap(UserDto.class, User.class);
        // UserDto -> User
        userDtoMap.addMappings(mapper -> {
            mapper.map(UserDto::getIdUser, User::setId);
            mapper.skip(User::setTasks);
        });

        // User -> UserDto
        TypeMap<User, UserDto> userMap = modelMapper.createTypeMap(User.class, UserDto.class);
        userMap.addMappings(mapper -> mapper.map(User::getId, UserDto::setIdUser));

        // Mapeo para creación (ignora ID y campos de auditoría)
        TypeMap<TaskCreateDto, Task> createMap = modelMapper.createTypeMap(TaskCreateDto.class, Task.class);
        createMap.addMappings(mapper -> {
            mapper.skip(Task::setId);
            mapper.skip(Task::setCreatedAt);
            mapper.skip(Task::setUpdatedAt);
            mapper.skip(Task::setUser);
        });

        // Mapeo para actualización (ignora campos inmutables)
        TypeMap<TaskUpdateDto, Task> updateMap = modelMapper.createTypeMap(TaskUpdateDto.class, Task.class);
        updateMap.addMappings(mapper -> {
            mapper.skip(Task::setId);
            mapper.skip(Task::setCreatedAt);
            mapper.skip(Task::setUser);
        });

        // Task -> TaskResponse
        TypeMap<Task, TaskResponse> taskResponseMap = modelMapper.createTypeMap(Task.class, TaskResponse.class);
        taskResponseMap.addMappings(mapper -> {
            mapper.map(Task::getId, TaskResponse::setIdTask);
            mapper.map(src -> src.getUser().getId(), TaskResponse::setUserId);
        });
    }

    public <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}