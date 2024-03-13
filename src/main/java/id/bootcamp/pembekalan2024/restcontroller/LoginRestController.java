package id.bootcamp.pembekalan2024.restcontroller;

import id.bootcamp.pembekalan2024.dto.LoginDTO;
import id.bootcamp.pembekalan2024.service.UserService;
import id.bootcamp.pembekalan2024.utils.CustomException;
import id.bootcamp.pembekalan2024.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginRestController {

    @Autowired
    private UserService us;

    @PostMapping("/login")
    public Resp<LoginDTO> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Resp<LoginDTO> response = new Resp<>();
        response.setCode(200);
        response.setMessage("OK");

        try {
            LoginDTO loginDTO = us.loginService(email, password);
            response.setData(loginDTO);
            return response;
        } catch (CustomException e){
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            return response;
        }
    }


}
