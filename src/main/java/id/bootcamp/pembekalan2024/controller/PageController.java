package id.bootcamp.pembekalan2024.controller;

import id.bootcamp.pembekalan2024.model.DataRole;
import id.bootcamp.pembekalan2024.model.DataUser;
import id.bootcamp.pembekalan2024.repositories.RegisterRepository;
import id.bootcamp.pembekalan2024.repositories.RoleRepository;
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
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RegisterRepository registerRepository;

    @GetMapping("/")
    public String loginForm(HttpServletRequest servlet, Model model) {
        String title_web = "Login";
        model.addAttribute("user", new DataUser());
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("user") DataUser dataUser, DataRole dataRole, HttpSession session) {
        DataRole existingUser = roleRepository.getUserByRole(dataUser.getUsername(), dataUser.getPassword());
        if (existingUser != null) {
            session.setAttribute("loggedInUser", existingUser);
            if ("admin".equals(existingUser.getRole())) {
                return "redirect:/list";
            } else if ("user".equals(existingUser.getRole())) {
                return "redirect:/register";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/stock")
    public String stock(HttpServletRequest servlet) {
        String title_web = "stock";
        return "stock";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest servlet, Model model) {
        String title_web = "register";
        model.addAttribute("user_data", new DataUser());
        return "register";
    }

    @PostMapping("/register")
    public String user(@ModelAttribute DataUser dataUser) {
        registerRepository.insertUser(dataUser.getUsername(), dataUser.getPassword());
        registerRepository.insertCustomer(registerRepository.getUserId(dataUser.getUsername(), dataUser.getPassword()),dataUser.getEmail(),dataUser.getNama_lengkap(), dataUser.getAlamat(), dataUser.getNo_telp());
        return "register";
    }

    @GetMapping("/cart_detail")
    public String cart_detail(HttpServletRequest servlet) {
        String title_web = "cart_detail";
        return "cart_detail";
    }

    @GetMapping("/list")
    public String cart(HttpServletRequest servlet) {
        String title_web = "list";
        return "list";
    }

//    @PostMapping("/customer")
//    public String customer(@RequestBody DataRegister dataRegister) {
//        registerRepository.insertCustomer(dataRegister.getNama(), dataRegister.getTgl_lahir(),
//                dataRegister.getAlamat(), dataRegister.getNo_telp());
//        return "/index.html"; // Redirect to index.html
//    }
}
