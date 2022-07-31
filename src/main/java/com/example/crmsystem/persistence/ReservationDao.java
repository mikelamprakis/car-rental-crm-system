package com.example.crmsystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.crmsystem.model.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer>  {
	
	public Reservation findById(
			@Param("reservation_id") int reservation_id);

}
