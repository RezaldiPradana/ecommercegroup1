package id.bootcamp.pembekalan2024.repositories;

import id.bootcamp.pembekalan2024.model.DataRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<DataRole, Long> {
    @Query(nativeQuery = true,
            value = "select * from public.\"user\" where username = :username and password = :password")
    public DataRole getUserByRole(
            @Param("username") String username,
            @Param("password") String password
    );

}
