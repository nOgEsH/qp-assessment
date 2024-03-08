package com.questionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.questionpro.entity.GroceryItem;
import com.questionpro.service.GroceryItemService;

@RequestMapping("/user")
public class UserController {

    @Autowired
    private GroceryItemService groceryItemService;
	
	@GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }
}
