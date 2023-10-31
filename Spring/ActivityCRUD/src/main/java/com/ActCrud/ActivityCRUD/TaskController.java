package com.ActCrud.ActivityCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController // Indicates that this class handles HTTP requests and produces JSON responses.
@RequestMapping("/tasks") // Maps this controller to the "/tasks" URL path.
public class TaskController {

    private final List<Task> tasks = new ArrayList<>(); // A list to store tasks.

    @PostMapping // Handles HTTP POST requests for creating tasks.
    public void addTask(@RequestBody Task task) { // Adds a task to the list.
        tasks.add(task);
    }

    @GetMapping // Handles HTTP GET requests for fetching all tasks.
    public List<Task> getAllTasks() { // Returns a list of all tasks.
        return tasks;
    }

    @GetMapping("/{id}") // Handles HTTP GET requests for fetching a task by its ID.
    public Task getTaskById(@PathVariable Long id) { // Returns a task by its ID.
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}") // Handles HTTP DELETE requests for deleting a task by its ID.
    public void deleteTaskById(@PathVariable Long id) { // Removes a task from the list by its ID.
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
