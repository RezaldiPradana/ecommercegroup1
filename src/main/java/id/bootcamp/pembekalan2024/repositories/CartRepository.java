package id.bootcamp.pembekalan2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
	
	@Query(nativeQuery = true,
			value = "select exists (select * from cart where id_user = :userId and is_delete = false)")
	public Boolean isCartNotEmpty(@Param("userId") Long userId);
	
	@Query(nativeQuery = true,
			value = "select * from cart where id_user = :userId and is_delete = false")
	public CartEntity getIdCart(@Param("userId") Long userId);

}
