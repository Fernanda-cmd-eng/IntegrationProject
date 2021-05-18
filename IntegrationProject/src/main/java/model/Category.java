package main.java.model;

import java.util.ArrayList;

public class Category {

	public Category(String name) {		
		this.name = name;
	}
	private String name;
	private ArrayList<String> models = new ArrayList<>(); //lista de modelos
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getModels() {
		return models;
	}
	public void setModels(ArrayList<String> models) {
		this.models = models;
	}
	@Override
	public String toString() {
		return name;
	}
}
