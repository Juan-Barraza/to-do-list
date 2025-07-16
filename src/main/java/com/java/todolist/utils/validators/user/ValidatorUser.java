package com.java.todolist.utils.validators.user;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.java.todolist.dto.user.UserDto;
import com.java.todolist.utils.exeptions.BusinessException;

import io.micrometer.common.util.StringUtils;

@Component
public class ValidatorUser {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern
            .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");


    public void validate(UserDto userDto) throws BusinessException {
        validateNonNullFields(userDto);
        validateUsername(userDto.getUsername());
        validateEmail(userDto.getEmail());
        validatePassword(userDto.getPassword());
    }

    public void validateNonNullFields(UserDto userDto) throws BusinessException {
        if (userDto == null) {
            throw new BusinessException("User data can not be null");
        }

        if (StringUtils.isBlank(userDto.getUsername())) {
            throw new BusinessException("Username can not be empty");
        }

        if (StringUtils.isBlank(userDto.getEmail())) {
            throw new BusinessException("Email can not be empty");
        }

        if (StringUtils.isBlank(userDto.getPassword())) {
            throw new BusinessException("Password can not be empty");
        }
    }

    public static void validateEmail(String email) throws BusinessException {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new BusinessException("Invalid email format");
        }
    }

    public static void validatePassword(String password) throws BusinessException {
        if (password.length() < 8) {
            throw new BusinessException("Password must be at least 8 characters long");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new BusinessException(
                    "Password must contain at least one digit, one lowercase, one uppercase letter, one special character and no whitespace");
        }
    }

    public static void validateUsername(String username) throws BusinessException {
        if (username.length() < 3) {
            throw new BusinessException("Username must be at least 3 characters long");
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new BusinessException("Username can only contain letters, numbers, dots, underscores and hyphens");
        }
    }
}
