package com.java.todolist.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.java.todolist.dto.user.UserDto;
import com.java.todolist.models.User;

@Component
public class MapeoUser {

    private final ModelMapper modelMapper;

    public MapeoUser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        configureMappings();

    }

     private void configureMappings() {
        // Configuración para UserDto -> User
        modelMapper.createTypeMap(UserDto.class, User.class)
            .addMappings(mapper -> {
                mapper.map(UserDto::getIdUser, User::setId);
                mapper.skip(User::setTasks); 
            });
        
        // Configuración para User -> UserDto
        modelMapper.createTypeMap(User.class, UserDto.class)
            .addMappings(mapper -> {
                mapper.map(User::getId, UserDto::setIdUser);
            });
    }


    public <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}