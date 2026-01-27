package com.example.demo;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Merge {
	public static void main(String[] args) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			JsonNode json1=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\Practice-Cg\\Json\\src\\main\\java\\com\\example\\demo\\j1.json"));
			JsonNode json2=mapper.readTree(new File("C:\\Users\\Anmol Tiwari\\git\\Practice-Cg\\Json\\src\\main\\java\\com\\example\\demo\\j2.json"));
			
			ObjectNode mergedNode =(ObjectNode)json1;
			
			mergedNode.setAll((ObjectNode)json2);
			
			System.out.println(mergedNode.toPrettyString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
