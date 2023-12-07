package test.server.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import test.server.demo.taskresult.CurrentLevelResponse;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getLevelByUsername(@PathVariable String username) {

        Optional<User> userOptional = userRepository.findByUserName(username);
        if (!userOptional.isPresent()) {
            // Handle the case where the user doesn't exist
            return ResponseEntity.notFound().build();
        }

        // Get the user object from the Optional
        User user = userOptional.get();

        User userDTO = new User();
        userDTO.setUserName(user.getUserName());
        userDTO.setId(user.getId());
        userDTO.setLevel(user.getLevel());

        return ResponseEntity.ok(userDTO);

    }


    @PostMapping("/user")
    public ResponseEntity<User> updateLevel(@RequestBody Map<String, Object> requestBody) {
        String username = (String) requestBody.get("username");
        Object levelObj = requestBody.get("level");

        if (levelObj instanceof Integer) {
            // If it's already an Integer, no need to parse
            int level = (Integer) levelObj;

            // Retrieve the user from the database using a service method or repository method
            User user = userRepository.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("Cannot find user with username: " + username));

            // Update the user's level
            user.setLevel(level);

            // Save the updated user
            userRepository.save(user);

            return ResponseEntity.ok(user);
        } else {
            // Handle the case where the "level" property in the requestBody is not an integer
            return ResponseEntity.badRequest().build();
        }


    }
}
