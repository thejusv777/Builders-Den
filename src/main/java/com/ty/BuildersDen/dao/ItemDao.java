package com.ty.BuildersDen.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.BuildersDen.dto.Item;
import com.ty.BuildersDen.dto.Orders;
import com.ty.BuildersDen.repository.ItemRepository;

@Repository
public class ItemDao {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderDao orderDao;
	
	public Item saveItem(int orderId,Item item) {
	   Orders orders =orderDao.getOrdersById(orderId);
		if(orders!=null) {
				itemRepository.save(item);
				return item;
			}
		
		return null;
	}
	
	public Item getItemById(int itemid) {
		Optional<Item> veOptional=itemRepository.findById(itemid);
		if(veOptional.isEmpty()) {
		   return null;
		}
		return veOptional.get();
	}
	
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}
	
	public boolean deleteItem(int itemid) {
		Item item=getItemById(itemid);
		if(item!=null) {
			itemRepository.deleteById(itemid);
			return true;
		}
		return false;
		
	}
	
	public Item updateItem(int itemId,Item item) {
		Item items=getItemById(itemId);
		if(items!=null) {
			itemRepository.save(item);
			return item;
		}
		return null;
		
	}
	
	public Item getItemObject() {
		return new Item();
	}


}
