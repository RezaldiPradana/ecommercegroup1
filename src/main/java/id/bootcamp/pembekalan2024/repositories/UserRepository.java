package id.bootcamp.pembekalan2024.repositories;

import id.bootcamp.pembekalan2024.entities.UserEntity;
import id.bootcamp.pembekalan2024.model.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DataUser, Long> {
    @Query(nativeQuery = true,
            value = "select * from user_data where username = :username and password = :password")
    public DataUser getUserByUSernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );

}
