package id.bootcamp.pembekalan2024.dto;

public class CheckoutDTO {

	public Long id_user;
	public Long id_cart_detail;
	public Integer quantity;
	public String item_code;
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public Long getId_cart_detail() {
		return id_cart_detail;
	}
	public void setId_cart_detail(Long id_cart_detail) {
		this.id_cart_detail = id_cart_detail;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	
}
