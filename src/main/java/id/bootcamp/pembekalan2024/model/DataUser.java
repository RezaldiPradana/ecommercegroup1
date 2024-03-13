package id.bootcamp.pembekalan2024.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class DataUser {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(length = 100)
    private String username;

    @Column(length = 255)
    private String password;

    @Column
    private String role;
}
