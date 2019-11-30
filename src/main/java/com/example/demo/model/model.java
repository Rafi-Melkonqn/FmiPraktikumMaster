package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class model implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name ;
	private String model ;
	private String type ;
	
	public model (){
		
	}
	
	public model(int id, String name, String model, String type) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.type = type ;
	}
	 public String getName() {
		return name; 
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id ;
	}
	
	@Override
	public String toString() {
		return "model [id=" + id +",name=" + name +",type= " + type + ",model=" + model + "]";
	}
}
