package com.java.todolist.utils.reponse.task;

import java.util.List;

public class TaskListResponse {
    private List<TaskResponse> tasks;

    public TaskListResponse(List<TaskResponse> taskResponses) {
        this.tasks = taskResponses;
    }

    public List<TaskResponse> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskResponse> tasks) {
        this.tasks = tasks;
    }

}
