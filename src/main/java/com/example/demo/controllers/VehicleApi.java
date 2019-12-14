package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.model;
import com.example.demo.repos.vehicleRepository;

@RestController
public class vehicleApi {
	
	private vehicleRepository vehicleRepo;
	
	@Autowired
	public vehicleApi(vehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
		
	}
	
	@GetMapping("/model")
	public ResponseEntity<List<model>> searchVehicle(@RequestParam(required=false) String name,
			@RequestParam(required=false) String model,
			@RequestParam String type ) {
				List<model> models = new ArrayList<>();
				
				if(null == name && null == model && null == type) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
				}
				models.addAll(vehicleRepo.findByNameLikeOrModelLikeOrType(name, model, type));
				
				if(models.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
				
				return ResponseEntity.ok(models);
			}
	}
	
		
	
	

