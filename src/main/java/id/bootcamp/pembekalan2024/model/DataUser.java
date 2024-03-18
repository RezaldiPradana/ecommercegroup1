package id.bootcamp.pembekalan2024.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_data")
public class DataUser {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String username;

    @Column(length = 255)
    private String password;

    @Column
    private String email;

    @Column
    private String nama_lengkap;

    @Column
    private String alamat;

    @Column
    private String no_telp;
}
