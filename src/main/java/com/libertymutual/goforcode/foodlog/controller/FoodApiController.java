package com.libertymutual.goforcode.foodlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.foodlog.model.FoodEntry;
import com.libertymutual.goforcode.foodlog.repository.FoodRepository;

@RestController 
@RequestMapping("/home")
public class FoodApiController {
	
	private FoodRepository foodRepo;
	
	public FoodApiController (FoodRepository foodRepo) {
		this.foodRepo = foodRepo;
	}
	
	@PostMapping("/foodlog")
	public FoodEntry returnFoodEntry(@RequestBody FoodEntry foodEntry) {
//		System.out.println(foodEntry.getFoodName());
		foodRepo.save(foodEntry);
		return foodEntry;
	}
	
	@GetMapping("/foodlog")
	public List<FoodEntry> getAllOfTheFoods() {
		List<FoodEntry> allFoodEntries = foodRepo.findAll();
		return allFoodEntries;
	}
	
	@GetMapping("/foodname")
	public List<String> getAllFoodNames() {
		List<FoodEntry> allFoodEntries = foodRepo.findAll();
		List<String> holdsStrings = new ArrayList<String>();
		for (FoodEntry fe : allFoodEntries) {
			String foodName = fe.getFoodName();
			holdsStrings.add(foodName);
		}
		
		return holdsStrings;
	}

	@DeleteMapping("/{id}") 
	public FoodEntry removeTheFoodEntry(@PathVariable long id) {
		FoodEntry foodEntry = foodRepo.findOne(id);
		foodRepo.delete(id);
		return foodEntry;
		
	}
	
	@PutMapping ("/{id}/update")
	public FoodEntry updateEntry(@RequestBody FoodEntry foodEntry, @PathVariable long id) {
		FoodEntry existing = foodRepo.findOne(id);
		existing.setFoodName(foodEntry.getFoodName());
		existing.setDateEaten(foodEntry.getDateEaten());
		foodEntry.setId(id);
		return foodRepo.save(foodEntry);
		
	}
}
