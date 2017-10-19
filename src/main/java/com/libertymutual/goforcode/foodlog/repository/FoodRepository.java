package com.libertymutual.goforcode.foodlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.foodlog.model.FoodEntry;

@Repository 
public interface FoodRepository extends JpaRepository<FoodEntry, Long> {

}
