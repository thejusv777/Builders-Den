package com.ty.BuildersDen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BuildersDen.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
