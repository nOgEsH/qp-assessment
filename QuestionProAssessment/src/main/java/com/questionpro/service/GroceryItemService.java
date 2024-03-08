package com.questionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.entity.GroceryItem;
import com.questionpro.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id).orElse(null);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedGroceryItem) {
        GroceryItem groceryItem = getGroceryItemById(id);
        if (groceryItem != null) {
            groceryItem.setName(updatedGroceryItem.getName());
            groceryItem.setPrice(updatedGroceryItem.getPrice());
            groceryItem.setQuantity(updatedGroceryItem.getQuantity());
            return groceryItemRepository.save(groceryItem);
        }
        return null;
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}