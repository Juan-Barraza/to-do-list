package com.java.todolist.dto.user;


public class UserDto implements _DTOEntity {
    private Long idUser;
    private String username, email;
    private String password;

    public UserDto() {
    }

    public UserDto(Long idUser, String username, String password, String email) {
        super();
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
