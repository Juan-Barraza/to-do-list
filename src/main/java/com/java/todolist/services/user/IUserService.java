package com.java.todolist.services.user;

import com.java.todolist.dto.user.UserDto;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.user.UserListResponse;
import com.java.todolist.utils.reponse.user.UserResponse;

public interface IUserService {
    public  UserResponse register(UserDto userDto);
    public UserListResponse getAll();
    public ApiResponse<UserResponse> getUserById(Long id);
}
