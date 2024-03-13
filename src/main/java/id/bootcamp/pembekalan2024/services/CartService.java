package id.bootcamp.pembekalan2024.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
import id.bootcamp.pembekalan2024.repositories.CartDetailRepository;

@Service
public class CartService {

	@Autowired
	CartDetailRepository cdr;
	
	public List<CartDetailDTO> findCartDetailByUserID(Long userId) {
		List<CartDetailDTO> cart = cdr.findCartDetailByUserId(userId);
		return cart;
	}
}
