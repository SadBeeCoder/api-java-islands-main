package test.server.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private TasksRepository tasksRepository;

    @Autowired
    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @GetMapping("/{taskId}")
    public Tasks listTask(@PathVariable Integer taskId) {
        // Find the task by ID
        Optional<Tasks> taskOptional = tasksRepository.findById(taskId);

        // Check if the task exists
        if (taskOptional.isPresent()) {
            Tasks task = taskOptional.get();
            return task;
        } else {
            // Handle the case when the task with the given ID is not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No entry this time :(");
        }
    }

}
