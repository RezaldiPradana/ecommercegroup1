package id.bootcamp.pembekalan2024.controller;

import id.bootcamp.pembekalan2024.entities.UserEntity;
import id.bootcamp.pembekalan2024.model.DataUser;
import id.bootcamp.pembekalan2024.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String loginForm(HttpServletRequest servlet,Model model) {
        String title_web = "Login";
        model.addAttribute("user", new DataUser());
        return "index";
    }
    @PostMapping("/")
    public String login(@ModelAttribute("user") UserEntity dataUser, HttpSession session) {
        DataUser existingUser = userRepository.getUserByUSernameAndPassword(dataUser.getUsername(),dataUser.getPassword());
        if (existingUser != null && existingUser.getPassword().equals(dataUser.getPassword())) {
            session.setAttribute("loggedInUser", existingUser);
            if ("admin".equals(existingUser.getRole())) {
                return "redirect:/stock";
            } else {
                return "redirect:/kasir";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/stock")
    public String stock (HttpServletRequest servlet) {
        String title_web = "stock";
        return "stock";
    }

    @GetMapping("/register")
    public String register (HttpServletRequest servlet) {
        String title_web = "register";
        return "register";
    }

    @GetMapping("/cart_detail")
    public String cart_detail (HttpServletRequest servlet) {
        String title_web = "cart_detail";
        return "cart_detail";
    }

    @GetMapping("/cart")
    public String cart (HttpServletRequest servlet) {
        String title_web = "cart";
        return "cart";
    }
}
