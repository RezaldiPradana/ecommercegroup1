package id.bootcamp.pembekalan2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query(nativeQuery = true,
			value = "SELECT EXISTS (\r\n"
					+ "    SELECT *\r\n"
					+ "    FROM m_user\r\n"
					+ "    WHERE username = :email \r\n"
					+ "        AND is_delete = false\r\n"
					+ ")")
	public Boolean isEmailExists(@Param("email") String email);
	
	@Query(nativeQuery = true,
			value = "SELECT EXISTS (\r\n"
					+ "    SELECT *\r\n"
					+ "    FROM m_user\r\n"
					+ "    WHERE password = :password"
					+ "        AND is_delete = false\r\n"
					+ ")")
	public Boolean isPasswordExists(@Param("password") String password);
	
	@Query(nativeQuery = true,
			value = "select * from m_user where username = :username")
	public UserEntity selectUserLogin(@Param("username") String username);
}
