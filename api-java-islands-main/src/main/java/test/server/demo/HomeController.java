package test.server.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import test.server.demo.questions.Question;
import test.server.demo.questions.QuestionsRepository;
import test.server.demo.task.Tasks;
import test.server.demo.task.TasksRepository;
import test.server.demo.user.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    private final QuestionsRepository questionsRepository;

    private final TasksRepository tasksRepository;

    private final UserRepository userRepository;


    @Autowired
    public HomeController(QuestionsRepository questionsRepository, TasksRepository tasksRepository, UserRepository userRepository) {
        this.questionsRepository = questionsRepository;
        this.tasksRepository = tasksRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initializeData() {
        Tasks task1 = new Tasks( """
        <style> code {font-size: 120%; background-color: rgba(0, 0, 0, 0.25); padding: 2px 4px; border-radius: 4px} </style>
        In Java, a variable is like a container that can hold different types of information, such as numbers, text, or 
        other data. Its main purpose is to store and manage data in your program. Think of it as a labeled box where you 
        can put things you want to use later. <br>
        For example, if you want to work with numbers, you can create a variable to store a number like this:<br> 
        <code>int myNumber = 10;</code><br>
        Here, we've created a variable called <code>myNumber</code> and assigned it the value 10. Later in your program, you 
        can use <code>myNumber</code> to perform calculations, display the value, or do other operations with that number.<br>
        So, the main purpose of a variable in Java is to hold and manipulate data, making it an essential concept for 
        programming in Java.
        """ );

        Tasks savedTask = tasksRepository.save(task1);

        Question[] question1 = {
                new Question("What is the main purpose of a variable in Java?", new String[]{
                        "To store and manipulate data",
                        "To store multiple values",
                        "To execute code repeatedly",
                        "To display text on the screen"
                }),
                new Question("How would you describe a variable in Java?", new String[]{
                        "A container for holding data",
                        "A way to make code more complicated",
                        "A type of software bug",
                        "A computer peripheral device"
                }),
                new Question("In Java, what kind of information can you store in a variable?", new String[]{
                        "Different types of data, such as numbers and text",
                        "Only text",
                        "Only numbers",
                        "Only pictures"
                }),
                new Question("Can you provide an example of how to create and assign a value to a variable in Java?", new String[]{
                        "int x = 42;",
                        "variable = \"Hello, Java!\";",
                        "if (condition) { } ",
                        "print(\"Variable\");"
                }),
                new Question("Why are variables important in Java programming?", new String[]{
                        "To store and manipulate data",
                        "To make the code longer",
                        "To confuse other programmers",
                        "To slow down the program"
                })
        };

        for (Question q : question1) {
            q.setTasks(savedTask);
            questionsRepository.save(q);
        }

        // Do same for task two
        Tasks task2 = new Tasks("In programming, operators are special symbols or keywords that allow you to " +
                "perform " +
                "operations on data, such as numbers and variables. They are like tools that help you manipulate and " +
                "work with data in your programs.\n" +
                "\n" +
                "For example, the addition operator (+) allows you to add two numbers together, and the assignment " +
                "operator (=) lets you assign a value to a variable." );
        Tasks savedTask2 = tasksRepository.save(task2);
        Question[] question2 = {
                new Question("What do operators do in programming?", new String[]{
                        "They allow you to perform operations on data",
                        "They make your code colorful",
                        "They display messages on the screen",
                        "They create new programming languages"

                })
        };
        question2[0].setTasks(savedTask2);
        questionsRepository.save(question2[0]);
    }
 }
