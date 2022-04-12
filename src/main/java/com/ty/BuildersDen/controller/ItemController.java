package com.ty.BuildersDen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BuildersDen.dto.Item;
import com.ty.BuildersDen.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/order/{order_id}/item")
	public Item saveItem(@RequestBody Item item, @PathVariable int order_id) {
		return itemService.saveItem(order_id, item);
	}
	
	@GetMapping("/item")
	public Item getItemById(@RequestParam int item_id) {
		return itemService.getItemById(item_id);
	}
	
	@GetMapping("/allitem")
	public List<Item> getAllItems(){
		return itemService.getAllItem();
	}
	
	@PutMapping("/item")
	public Item updateItem(@RequestParam int id ,@RequestBody Item item) {
		return itemService.updateItem(id, item);
	}
	
	@DeleteMapping("/item")
	public boolean deleteItemById(@RequestParam int item_id) {
		return itemService.deleteItem(item_id);
	}
	
	@GetMapping("/emptyitem")
	public Item getItem() {
		return itemService.getItemObject();
	}
}
