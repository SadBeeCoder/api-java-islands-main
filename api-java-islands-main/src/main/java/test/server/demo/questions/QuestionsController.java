package test.server.demo.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.server.demo.task.Tasks;
import test.server.demo.task.TasksRepository;

import java.util.List;
@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private final TasksRepository tasksRepository;
    private final QuestionsRepository questionsRepository;


    @Autowired
    public QuestionsController(TasksRepository tasksRepository, QuestionsRepository questionsRepository) {
        this.tasksRepository = tasksRepository;
        this.questionsRepository = questionsRepository;
    }

    @GetMapping("/questions/{taskId}")
    public ResponseEntity<List<Question>> listQuestionsByTaskId(@PathVariable  Integer taskId) {
        Tasks task = tasksRepository.findById(taskId).orElse(null);

        if (task != null) {
            List<Question> questions = questionsRepository.findByTasks(task);
            return ResponseEntity.ok(questions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
