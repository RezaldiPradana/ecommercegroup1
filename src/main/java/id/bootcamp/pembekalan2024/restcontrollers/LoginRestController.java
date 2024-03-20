package id.bootcamp.pembekalan2024.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bootcamp.pembekalan2024.dto.LoginDTO;
import id.bootcamp.pembekalan2024.dto.RegisterDTO;
import id.bootcamp.pembekalan2024.services.UserService;
import id.bootcamp.pembekalan2024.utils.CustomException;
import id.bootcamp.pembekalan2024.utils.Resp;

@RestController
@RequestMapping("/api")
public class LoginRestController {

	@Autowired
	UserService us;
	
	@PostMapping("/login")
	public Resp<LoginDTO> login(@RequestParam("username") String username, @RequestParam("password") String password){
		Resp<LoginDTO> response = new Resp<>();
		try {
			LoginDTO data = us.login(username, password);
			response.setCode(200);
			response.setMessage("Ok");
			response.setData(data);
		} catch (CustomException e) {
			response.setCode(e.getCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/register")
	public Resp<String> register(@RequestBody RegisterDTO register){
		Resp<String> response = new Resp<>();
		try {
			us.register(register);
			response.setCode(200);
			response.setMessage("Ok");
		} catch (CustomException e) {
			response.setCode(e.getCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
