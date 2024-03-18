package id.bootcamp.pembekalan2024.repositories;

import id.bootcamp.pembekalan2024.model.DataRole;
import id.bootcamp.pembekalan2024.model.DataUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RegisterRepository extends JpaRepository<DataUser, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "INSERT INTO public.\"user\" (username, password, role) VALUES (:username, :password, 'admin')")
    public void insertUser(
            @Param("username") String username,
            @Param("password") String password
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "INSERT INTO public.customer (id_user, email, nama_lengkap, alamat, no_telp) VALUES (:id_user, :email, :nama_lengkap, :alamat, :no_telp)")
    public void insertCustomer(
            @Param("id_user") String id_user,
            @Param("email") String email,
            @Param("nama_lengkap") String nama_lengkap,
            @Param("alamat") String alamat,
            @Param("no_telp") String no_telp
    );

    @Query(nativeQuery = true,
            value = "select id_user from public.\"user\" where username = :username and password = :password")
    public String getUserId(
            @Param("username") String username,
            @Param("password") String password
    );


}
