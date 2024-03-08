package com.questionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.entity.GroceryItem;
import com.questionpro.service.GroceryItemService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private GroceryItemService groceryItemService;

   
    @PostMapping("/add")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.addGroceryItem(groceryItem);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id) {
        GroceryItem groceryItem = groceryItemService.getGroceryItemById(id);
        if (groceryItem != null) {
            return ResponseEntity.ok(groceryItem);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id,@RequestBody GroceryItem groceryItem){
    	
    	GroceryItem updateGroceryItem = groceryItemService.updateGroceryItem(id, groceryItem);
    	 if (updateGroceryItem != null) {
             return ResponseEntity.ok(groceryItem);
         }
         return ResponseEntity.notFound().build();
    
    }
    }