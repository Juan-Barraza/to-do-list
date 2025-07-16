package com.java.todolist.utils.reponse.user;

import com.java.todolist.dto.user.UserDto;

public class UserResponse {
    private Long idUser;
    private String username, email;

    public UserResponse(UserDto user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();

    }
    

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
