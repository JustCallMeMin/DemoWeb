package trinhnguyenhoangminh.demoweb.Controllers;

import trinhnguyenhoangminh.demoweb.Entities.User;
import trinhnguyenhoangminh.demoweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "Auth/register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "Auth/login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
