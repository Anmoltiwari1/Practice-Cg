package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJson {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			JsonNode rootNode = mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\Practice-Cg\\Json\\src\\main\\java\\com\\example\\demo\\data.json"));
			
			String name=rootNode.get("name").asText();
			String emailString=rootNode.get("email").asText();
			
			System.out.println("Name :"+name);
			System.out.println("email :"+emailString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
