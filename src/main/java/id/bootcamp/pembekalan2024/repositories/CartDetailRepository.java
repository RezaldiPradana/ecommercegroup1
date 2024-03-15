package id.bootcamp.pembekalan2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.entities.CartDetailEntity;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long>{

	@Query(nativeQuery = true,
			value = "select count(id_cart_detail) from cart_detail\r\n"
					+ "join cart on cart.id_cart = cart_detail.id_cart\r\n"
					+ "where cart.id_user = :userId and cart_detail.is_delete = false")
	public Integer getTotalItemCart(@Param("userId") Long userId);
}
