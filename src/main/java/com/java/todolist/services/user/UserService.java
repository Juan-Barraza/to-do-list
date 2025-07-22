package com.java.todolist.services.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.todolist.dto.user.UserDto;
import com.java.todolist.models.User;
import com.java.todolist.repositories.IUserRepository;
import com.java.todolist.utils.Mapeo;
import com.java.todolist.utils.exeptions.BusinessException;
import com.java.todolist.utils.exeptions.ResourceNotFoundException;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.user.UserListResponse;
import com.java.todolist.utils.reponse.user.UserResponse;
import com.java.todolist.utils.validators.user.ValidatorUser;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final Mapeo mapper;
    private final PasswordEncoder passwordEncoder;
    private final ValidatorUser validatorUser;

    public UserService(IUserRepository userRepository, Mapeo mapper, PasswordEncoder passwordEncoder, ValidatorUser validatorUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.validatorUser = validatorUser;
    }

    @Override
    @Transactional
    public UserResponse register(UserDto userDto) {
        validatorUser.validate(userDto);
        
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new BusinessException("Username already exists");
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new BusinessException("Email already registered");
        }

        User user = mapper.convertToEntity(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse(mapper.convertToDto(savedUser, UserDto.class));
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public UserListResponse getAll() {
        List<User> users = userRepository.findAllUsers();
        List<UserResponse> userResponse = users.stream()
            .map(user -> {
                UserDto dto = mapper.convertToDto(user, UserDto.class);
                return new  UserResponse(dto);
            })
            .collect(Collectors.toList());

        UserListResponse response = new UserListResponse(userResponse);

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<UserResponse> getUserById(Long id) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ApiResponse<UserResponse> response = ApiResponse.success(new UserResponse(mapper.convertToDto(user, UserDto.class)));

        return response;
    }
}