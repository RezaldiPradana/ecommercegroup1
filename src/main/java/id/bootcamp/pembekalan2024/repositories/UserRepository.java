package id.bootcamp.pembekalan2024.repositories;

import id.bootcamp.pembekalan2024.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Buat Fungsi yang mengimplementasi Query tadi
    //Nama fungsinya : getUserByEmailAndPassword
    //Return Value : UserEntity
    //Parameter email dan password
    @Query(nativeQuery = true,
            value = "select * from m_user "
                    + "where email = :email and password = :password")
    public UserEntity getUserByEmailAndPassword(
            @Param("email") String email,
            @Param("password") String password
    );

    @Query(nativeQuery = true,
            value = "select exists (select * from m_user where email ilike :email and is_delete = false)")
    public Boolean isEmailExists(@Param("email") String email);
}
