package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.ItemDao;
import com.ty.BuildersDen.dto.Item;
import com.ty.BuildersDen.exception.IdNotFoundException;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public Item saveItem(int orderId, Item item) {
		return itemDao.saveItem(orderId, item);
	}

	public Item getItemById(int id) {
		Item item= itemDao.getItemById(id);
		
		if(item== null) {
			throw new IdNotFoundException("Given "+id+" Not Exit ");
		}
		return item;

	}

	public List<Item> getAllItem() {
		return itemDao.getAllItem();

	}

	public boolean deleteItem(int itemid) {
		return itemDao.deleteItem(itemid);
	}

	public Item updateItem(int itemId, Item item) {
		return itemDao.updateItem(itemId, item);
	}

	public Item getItemObject() {
		return itemDao.getItemObject();
	}
}
