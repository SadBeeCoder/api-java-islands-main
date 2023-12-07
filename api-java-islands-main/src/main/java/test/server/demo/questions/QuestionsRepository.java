package test.server.demo.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import test.server.demo.task.Tasks;

import java.util.List;

public interface QuestionsRepository  extends JpaRepository<Question, Long> {
       List<Question> findByTasks(Tasks task);
}
