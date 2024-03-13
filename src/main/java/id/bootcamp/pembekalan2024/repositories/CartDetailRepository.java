package id.bootcamp.pembekalan2024.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.dto.CartDetailDTO;
import id.bootcamp.pembekalan2024.entities.CartDetailEntity;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {

	@Query(nativeQuery = true,
			value = "select product_name, cd.quantity, s.price\r\n"
					+ "from cart_detail cd\r\n"
					+ "join cart c on c.id_cart = cd.id_cart\r\n"
					+ "join stock s on s.item_code = cd.item_code\r\n"
					+ "where c.id_user = 1")
	public List<CartDetailDTO> findCartDetailByUserId(@Param("User_id") Long User_id);
}
