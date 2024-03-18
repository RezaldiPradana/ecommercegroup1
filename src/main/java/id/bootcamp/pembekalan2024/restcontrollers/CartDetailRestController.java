package id.bootcamp.pembekalan2024.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
import id.bootcamp.pembekalan2024.dto.CheckoutDTO;
import id.bootcamp.pembekalan2024.services.CartService;
import id.bootcamp.pembekalan2024.utils.Resp;

@RestController
@RequestMapping("/api/cart_detail")
public class CartDetailRestController {

	@Autowired
	CartService cs;
	
	@PostMapping("")
	public Resp<List<CartDetailDTO>> getCartDetailByUserId(@RequestParam("user_id") Long user_id){
		Resp<List<CartDetailDTO>> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(cs.findCartDetailByUserID(user_id));
		return response;
	}
	@PostMapping("/checkout")
	public Resp<String> updateCartDetail(@RequestBody List<CheckoutDTO> cart){
		Resp<String> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		cs.reduceStock(cart);
		return response;
	}
}
