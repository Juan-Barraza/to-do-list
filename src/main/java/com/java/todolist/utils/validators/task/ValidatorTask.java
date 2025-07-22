package com.java.todolist.utils.validators.task;

import org.springframework.stereotype.Component;

import com.java.todolist.dto.task.TaskCreateDto;
import com.java.todolist.utils.exeptions.BusinessException;

import io.micrometer.common.util.StringUtils;

@Component
public class ValidatorTask {

    public void validate(TaskCreateDto task) throws BusinessException {
        validateNonNullFields(task);
    }

    public void validateNonNullFields(TaskCreateDto task) throws BusinessException {
        if (task == null) {
            throw new BusinessException("Task data can nit be null");
        }

        if (StringUtils.isBlank(task.getTitle())) {
            throw new BusinessException("Title can not be empty");
        }

        if (StringUtils.isBlank(task.getDescription())) {
            throw new BusinessException("Description can not be null");
        }

        if (task.getUserId() == null) {
            throw new BusinessException("User can not be null");
        }

        if (task.getDueDate() == null) {
            throw new BusinessException("DueDate can not be null");
        }
    }

}
