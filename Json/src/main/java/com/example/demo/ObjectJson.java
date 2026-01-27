package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
	private String brand;
	private String model;
	private double price;
	
	public Car(String brand, String model, double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	
	public String getModel() {
		return model;
	}

	
	public double getPrice() {
		return price;
	}

	
	
}

public class ObjectJson {
	public static void main(String[] args) {
		
		Car car=new Car("BMW","A8",25000000);
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			String json = mapper.writeValueAsString(car);
			System.out.println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
