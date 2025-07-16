package com.java.todolist.utils.reponse.user;

import java.util.List;

public class UserListResponse {
    private List<UserResponse> userRespo;

    public UserListResponse(List<UserResponse> userResponse) {
        this.userRespo = userResponse;
    }

    public List<UserResponse> getUserRespo() {
        return userRespo;
    }

    public void setUserRespo(List<UserResponse> userRespo) {
        this.userRespo = userRespo;
    }

    
}
