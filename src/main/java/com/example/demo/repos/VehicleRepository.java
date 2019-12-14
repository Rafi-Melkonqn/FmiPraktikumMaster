package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.model;


@Repository

public interface vehicleRepository extends JpaRepository<model, Integer> {
	
	List<model>findByNameLikeOrModelLikeOrType(String name, String model, String type);

}
