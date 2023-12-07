package test.server.demo.questions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;
import test.server.demo.task.Tasks;

@Entity
@Table(name = "questions")
@CrossOrigin(origins = "http://localhost:4200")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long questionId;
    private String question;
    private String[] answers = new String[4];
    @ManyToOne
    @JoinColumn(name = "taskId")
    @JsonIgnore
    private Tasks tasks;

    public Question() {
    }

    public Question(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question(String question, String[] answers, Tasks tasks) {
        this.question = question;
        this.answers = answers;
        this.tasks = tasks;
    }

    public Question(Long questionId, String question, String[] answers, Tasks tasks) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
        this.tasks = tasks;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }


}




