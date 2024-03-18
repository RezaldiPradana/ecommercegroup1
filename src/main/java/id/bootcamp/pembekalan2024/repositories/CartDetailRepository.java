package id.bootcamp.pembekalan2024.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
import id.bootcamp.pembekalan2024.entities.CartDetailEntity;
import jakarta.transaction.Transactional;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {

	@Query(nativeQuery = true,
			value = "select id_cart_detail, product_name, cd.quantity, s.price, cd.item_code\r\n"
					+ "from cart_detail cd\r\n"
					+ "join cart c on c.id_cart = cd.id_cart\r\n"
					+ "join stock s on s.item_code = cd.item_code\r\n"
					+ "where c.id_user = :User_id and cd.is_delete = false")
	public List<CartDetailDTO> findCartDetailByUserId(@Param("User_id") Long User_id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true,
			value = "update cart_detail\r\n"
					+ "set is_delete = true, deleted_by = :User_id, deleted_on = now()\r\n"
					+ "from cart c \r\n"
					+ "where cart_detail.id_cart = c.id_cart and id_user = :User_id")
	public void updateDataCartDetail(@Param("User_id") Long User_id);

	@Query(nativeQuery = true,
			value = "select count(id_cart_detail) from cart_detail\r\n"
					+ "join cart on cart.id_cart = cart_detail.id_cart\r\n"
					+ "where cart.id_user = :userId and cart_detail.is_delete = false")
	public Integer getTotalItemCart(@Param("userId") Long userId);
}

