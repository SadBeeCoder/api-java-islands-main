package test.server.demo.task;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    Optional<Tasks> findById(Integer taskId);


}
