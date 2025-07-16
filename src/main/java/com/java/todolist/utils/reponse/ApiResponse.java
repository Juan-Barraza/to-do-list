package com.java.todolist.utils.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.java.todolist.utils.errors.ErrorResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;

    private T data;

    private ErrorResponse error;

    private ApiResponse(boolean success, T data, ErrorResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> error(ErrorResponse error) {
        return new ApiResponse<>(false, null, error);
    }

    public boolean isSuccess() {
        return success;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public T getData() {
        return data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ErrorResponse getError() {
        return error;
    }

}
