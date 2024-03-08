package com.questionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
	
}
