package id.bootcamp.pembekalan2024.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bootcamp.pembekalan2024.dto.LoginDTO;
import id.bootcamp.pembekalan2024.dto.RegisterDTO;
import id.bootcamp.pembekalan2024.entities.UserEntity;
import id.bootcamp.pembekalan2024.repositories.UserRepository;
import id.bootcamp.pembekalan2024.utils.CustomException;


@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public LoginDTO login (String username, String password) throws CustomException {
		Boolean isEmailExists = ur.isEmailExists(username);
		if(!isEmailExists) {
			throw new CustomException(452, "Email or Password is wrong !!!");
		}
		Boolean isPasswordExists = ur.isPasswordExists(password);
		if(!isPasswordExists) {
			throw new CustomException(452, "Email or Password is wrong !!!");
		}
		UserEntity user = ur.selectUserLogin(username);
		LoginDTO login = new LoginDTO();
		login.setRole(user.getRole());
		login.setUser_id(user.getId_user());
		return login;
		
	}
	public void register(RegisterDTO register) throws CustomException {
		Boolean isEmailExists = ur.isEmailExists(register.getUsername());
		if(isEmailExists) {
			throw new CustomException(452, "Username is already used !!!");
		}
		UserEntity user = new UserEntity();
		user.setCreated_by(-1L);
		user.setCreated_on(new Date());
		user.setPassword(register.getPassword());
		user.setRole(register.getRole());
		user.setUsername(register.getUsername());
		ur.save(user);
	}
}
