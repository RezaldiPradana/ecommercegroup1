package id.bootcamp.pembekalan2024.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseProperties {

	@Id
	@Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cart;
	
	@Column
	private Long id_user;
	
	@Column
	private Integer total_price;
	
	@Column
	private Date purchase_date;

	public Long getId_cart() {
		return id_cart;
	}

	public void setId_cart(Long id_cart) {
		this.id_cart = id_cart;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
}
