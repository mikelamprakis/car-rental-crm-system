package com.example.crmsystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.crmsystem.model.Manager;


@Repository
public interface ManagerDao extends JpaRepository<Manager, Integer>{
	
	public Manager findByUsernameAndPassword(
			@Param("username")String username,
			@Param("password")String password);

}
