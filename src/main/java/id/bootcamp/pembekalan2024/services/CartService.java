package id.bootcamp.pembekalan2024.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
import id.bootcamp.pembekalan2024.dto.CheckoutDTO;
import id.bootcamp.pembekalan2024.entities.CartDetailEntity;
import id.bootcamp.pembekalan2024.entities.StockEntity;
import id.bootcamp.pembekalan2024.repositories.CartDetailRepository;
import id.bootcamp.pembekalan2024.repositories.StockRepository;

@Service
public class CartService {

	@Autowired
	CartDetailRepository cdr;
	
	@Autowired
	StockRepository sr;
	
	public List<CartDetailDTO> findCartDetailByUserID(Long userId) {
		List<CartDetailDTO> cart = cdr.findCartDetailByUserId(userId);
		return cart;
	}
	public void reduceStock(List<CheckoutDTO> carts) {
		for (CheckoutDTO cart : carts) {
			CartDetailEntity oneCart = cdr.getReferenceById(cart.getId_cart_detail());
			oneCart.setDeleted_by(cart.getId_user());
			oneCart.setDeleted_on(new Date());
			cdr.save(oneCart);
			Integer stockDibeli = cart.getQuantity();
			StockEntity stock = sr.getAllEntityByItemCode(cart.getItem_code());
			Integer stockAwal = stock.getQuantity();
			Integer StockAkhir = stockAwal - stockDibeli;
			stock.setModified_by(cart.getId_user());
			stock.setModified_on(new Date());
			stock.setQuantity(StockAkhir);
			sr.save(stock);
			
		}
		
	}
}
