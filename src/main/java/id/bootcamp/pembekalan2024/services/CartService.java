package id.bootcamp.pembekalan2024.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
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
	public void reduceStock(Long userId) {
		cdr.updateDataCartDetail(userId);
		List<CartDetailDTO> cart = cdr.findCartDetailByUserId(userId);
		
		for(int i = 0; i< cart.size();i++) {
			Integer qttDibeli = cart.get(i).getQuantity();
			StockEntity stock = sr.getAllEntityByItemCode(cart.get(i).getItem_code());
			Integer qttAwal = stock.getQuantity();
			stock.setQuantity(qttAwal-qttDibeli);
			stock.setModified_by(userId);
			stock.setModified_on(new Date());
			sr.save(stock);
		}
	}
}
