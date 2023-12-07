package test.server.demo.user;

import jakarta.persistence.*;
//import test.server.demo.taskresult.TaskResult;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "userName" }) })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String userName;
    private String password;

    private int level;
    private boolean active;
    private String roles;
//    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<TaskResult> taskResults = new ArrayList<>();

    public User() {
        // Per default every user receivers normal rights
        // Make sure that you prefix with ROLE_
        // Add ",ROLE_ADMIN" for additional admin rights
        this.roles = "ROLE_USER";
        // Per default each user is active
        this.active = true;
        this.level = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
