package id.bootcamp.pembekalan2024.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.entities.StockEntity;

@Repository
public interface ProductRepository extends JpaRepository<StockEntity, Long>{
	
	@Query(nativeQuery = true,
			value = "select * from stock where is_delete is false order by id_stock")
	public List<StockEntity> getAllProduct();
	
	@Query(nativeQuery = true,
			value = "select * from stock where item_code = :itemCode")
	public StockEntity getProductByCode(@Param("itemCode") String itemCode);

}
