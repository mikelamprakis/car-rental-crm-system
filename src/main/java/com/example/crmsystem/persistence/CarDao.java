package com.example.crmsystem.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.crmsystem.model.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
	
	@Override
	public List<Car> findAll();
	Car findByModel(@Param("model")String model);
	
}
