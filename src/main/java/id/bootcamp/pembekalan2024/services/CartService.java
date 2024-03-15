package id.bootcamp.pembekalan2024.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bootcamp.pembekalan2024.dto.PostCartDTO;
import id.bootcamp.pembekalan2024.dto.PostDetailCartDTO;
import id.bootcamp.pembekalan2024.entities.CartDetailEntity;
import id.bootcamp.pembekalan2024.entities.CartEntity;
import id.bootcamp.pembekalan2024.repositories.CartDetailRepository;
import id.bootcamp.pembekalan2024.repositories.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cr;
	@Autowired
	private CartDetailRepository cdr;
	
	public Boolean isCartExists(Long userId) {
		return cr.isCartNotEmpty(userId);
	}
	public CartEntity getCartId(Long userId) {
		return cr.getIdCart(userId);
	}
	public Integer getTotalItem(Long userId) {
		return cdr.getTotalItemCart(userId);
	}
	
	public void createNewCart(PostCartDTO postCartDto) {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId_user(postCartDto.getId_user());
		cartEntity.setPurchase_date(new Date());
		cartEntity.setCreated_by(postCartDto.getId_user());
		cartEntity.setCreated_on(new Date());
		
		cr.save(cartEntity);
	}
	
	public void insertProductToCart(PostDetailCartDTO detailDto) {
		CartDetailEntity detailEntity = new CartDetailEntity();
		detailEntity.setId_cart(detailDto.getId_cart());
		detailEntity.setItem_code(detailDto.getItem_code());
		detailEntity.setPrice(detailDto.getPrice());
		detailEntity.setQuantity(detailDto.getQuantity());
		detailEntity.setCreated_by(detailDto.getId_user());
		detailEntity.setCreated_on(new Date());
		
		cdr.save(detailEntity);
	}
	
	
}
