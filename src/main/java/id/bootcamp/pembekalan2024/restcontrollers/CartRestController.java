package id.bootcamp.pembekalan2024.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bootcamp.pembekalan2024.dto.PostCartDTO;
import id.bootcamp.pembekalan2024.dto.PostDetailCartDTO;
import id.bootcamp.pembekalan2024.entities.CartDetailEntity;
import id.bootcamp.pembekalan2024.entities.CartEntity;
import id.bootcamp.pembekalan2024.services.CartService;
import id.bootcamp.pembekalan2024.utils.Resp;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	CartService cs;
	
	@GetMapping("/isExists")
	public Resp<Boolean> isCartExists(@RequestParam("user_id") Long userId) {
		Resp<Boolean> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(cs.isCartExists(userId));
		return response;
	}
	@GetMapping("/id")
	public Resp<CartEntity> getCartId(@RequestParam("user_id") Long userId) {
		Resp<CartEntity> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(cs.getCartId(userId));
		return response;
	}
	@GetMapping("/total-product")
	public Resp<Integer> getTotalItemCart(@RequestParam("user_id") Long userId) {
		Resp<Integer> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(cs.getTotalItem(userId));
		return response;
	}
	
	
	@PostMapping("/new")
	public Resp<CartEntity> newCart(@RequestBody PostCartDTO postCartDto) {
		Resp<CartEntity> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		cs.createNewCart(postCartDto);
		return response;
	}
	
	@PostMapping("/detail")
	public Resp<CartDetailEntity> insertDetailCart(@RequestBody PostDetailCartDTO postDetailDto) {
		Resp<CartDetailEntity> response = new Resp<>();
		response.setCode(200);
		response.setMessage("OK");
		cs.insertProductToCart(postDetailDto);
		return response;
	}
}
