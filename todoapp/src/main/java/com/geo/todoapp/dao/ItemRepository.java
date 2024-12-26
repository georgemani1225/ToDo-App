package com.geo.todoapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.todoapp.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    public List<Item> findAllByOrderByItemDateAsc();

}
