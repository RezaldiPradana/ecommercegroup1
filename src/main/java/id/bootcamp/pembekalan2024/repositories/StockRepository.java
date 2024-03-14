package id.bootcamp.pembekalan2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.bootcamp.pembekalan2024.entities.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

	@Query(nativeQuery = true,
			value = "select * from stock where item_code = :kode")
	public StockEntity getAllEntityByItemCode(@Param("kode") String kode);
}
