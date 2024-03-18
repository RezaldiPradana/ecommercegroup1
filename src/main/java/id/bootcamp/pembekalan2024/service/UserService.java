package id.bootcamp.pembekalan2024.service;

import id.bootcamp.pembekalan2024.dto.LoginDTO;
import id.bootcamp.pembekalan2024.model.DataUser;
import id.bootcamp.pembekalan2024.repositories.UserRepository;
import id.bootcamp.pembekalan2024.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;
    public LoginDTO loginService(String username, String password) throws CustomException {
        //Memanggil Fungsi
        DataUser dataUser = ur.getUserByUSernameAndPassword(username, password);

        if(dataUser != null) {
            LoginDTO loginDto = new LoginDTO();
            loginDto.setUser_id(dataUser.getId());
            return loginDto;
        } else {
            throw new CustomException(452, "Usename atau Password salah!");
        }
    }
}
