package id.bootcamp.pembekalan2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.bootcamp.pembekalan2024.entities.CartDetailEntity;

public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {

	
}
