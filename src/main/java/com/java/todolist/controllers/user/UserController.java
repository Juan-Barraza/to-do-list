package com.java.todolist.controllers.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.todolist.controllers.BaseController;
import com.java.todolist.dto.user.UserDto;
import com.java.todolist.services.user.IUserService;
import com.java.todolist.utils.reponse.ApiResponse;
import com.java.todolist.utils.reponse.user.UserListResponse;
import com.java.todolist.utils.reponse.user.UserResponse;

@RestController
@RequestMapping("api/v1/users")
public class UserController extends BaseController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        UserResponse response = userService.register(userDto);
        return createdResponse(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        ApiResponse<UserResponse> response = userService.getUserById(id);
        return successResponse(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        UserListResponse response = userService.getAll();
        return successResponse(response);
    }
}
