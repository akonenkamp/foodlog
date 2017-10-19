package com.libertymutual.goforcode.foodlog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodEntry {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column (nullable = false)
	private String foodName;
	
	@Column (nullable = false)
	private String dateEaten;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDateEaten() {
		return dateEaten;
	}

	public void setDateEaten(String dateEaten) {
		this.dateEaten = dateEaten;
	}
	
	
	

}
