package test.server.demo.task;

import jakarta.persistence.*;
import test.server.demo.questions.Question;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tasks")
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer taskId;
    @Column (length = 2000)
    private String explanation;

    @OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Tasks() {
    }

    public Tasks(String explanation) {
        this.explanation = explanation;
    }

    public Tasks(String explanation, List<Question> questions) {
        this.explanation = explanation;
        this.questions = questions;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestions(Question question) {
        questions.add(question);
    }


}
