package id.bootcamp.pembekalan2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity extends BaseProperties {

	@Id
	@Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stock;
	
	@Column(nullable = false)
	private String item_code;
	
	@Column
	private String product_name;
	
	@Column
	private String product_type;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer price;
	
	@Column
	private String image_path;
	
	@Column
	private String description;

	public Long getId_stock() {
		return id_stock;
	}

	public void setId_stock(Long id_stock) {
		this.id_stock = id_stock;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
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

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
