package id.bootcamp.pembekalan2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_detail")
public class CartDetailEntity extends BaseProperties {

	@Id
	@Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cart_detail;
	
	@Column
	private Long id_cart;
	
	@Column
	private String item_code;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer price;

	public Long getId_cart_detail() {
		return id_cart_detail;
	}

	public void setId_cart_detail(Long id_cart_detail) {
		this.id_cart_detail = id_cart_detail;
	}

	public Long getId_cart() {
		return id_cart;
	}

	public void setId_cart(Long id_cart) {
		this.id_cart = id_cart;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
