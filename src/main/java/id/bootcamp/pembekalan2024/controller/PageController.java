package id.bootcamp.pembekalan2024.controller;

import id.bootcamp.pembekalan2024.entities.UserEntity;
import id.bootcamp.pembekalan2024.model.DataUser;
import id.bootcamp.pembekalan2024.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    UserRepository userRepository;
    @GetMapping("/")
    public String loginForm(HttpServletRequest servlet,Model model) {
        String title_web = "Login";
        model.addAttribute("user", new DataUser());
        return "index.html";
    }
    @PostMapping("/")
    public String login(@ModelAttribute("user") UserEntity dataUser, HttpSession session) {
        UserEntity existingUser = userRepository.getUserByUSernameAndPassword(dataUser.getUsername(),dataUser.getPassword());
        if (existingUser != null && existingUser.getPassword().equals(dataUser.getPassword())) {
            session.setAttribute("loggedInUser", existingUser);
            if ("admin".equals(existingUser.getRole())) {
                return "redirect:/list";
            } else {

            }
        }
        return "redirect:/";
    }
}
