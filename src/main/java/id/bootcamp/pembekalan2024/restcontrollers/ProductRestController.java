package id.bootcamp.pembekalan2024.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bootcamp.pembekalan2024.entities.StockEntity;
import id.bootcamp.pembekalan2024.repositories.ProductRepository;
import id.bootcamp.pembekalan2024.utils.Resp;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	ProductRepository pr;
	
	@GetMapping("/product") 
	public Resp<List<StockEntity>> getAllProduct() {
		Resp<List<StockEntity>> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(pr.getAllProduct());
		return response;
	}
	
	@GetMapping("/product/detail")
	public Resp<StockEntity> getProductByCode(@RequestParam("item_code") String itemCode) {
		Resp<StockEntity> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(pr.getProductByCode(itemCode));
		return response;
		
	}
}
