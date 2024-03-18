package id.bootcamp.pembekalan2024.dto;

public class PostDetailCartDTO {

	private Long id_user;
	
	private Long id_cart_detail;
	private Long id_cart;
	
	private String item_code;
	private Integer quantity;
	private Integer price;
	
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
