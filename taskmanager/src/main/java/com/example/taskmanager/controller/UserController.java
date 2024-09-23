import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("Registering user: " + user.getUsername());
        return userService.registerUser(user.getUsername(), user.getPassword());
    }
}
