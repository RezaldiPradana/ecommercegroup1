package id.bootcamp.pembekalan2024.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseProperties {

	@Id
	@Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String email;

	@Column(length = 255)
	private String nama_lengkap;

	@Column
	private String alamat;

	@Column(length = 15)
	private String no_telp;

	public Long getId_user() {
		return id;
	}

	public void setId_user(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNama_lengkap() {
		return nama_lengkap;
	}

	public void setNama_lengkap(String nama) {
		this.nama_lengkap = nama_lengkap;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}


}
