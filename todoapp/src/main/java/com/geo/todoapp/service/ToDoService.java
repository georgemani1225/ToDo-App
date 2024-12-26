package com.geo.todoapp.service;

import java.util.List;

import com.geo.todoapp.entity.Item;

public interface ToDoService {

    List<Item> findAll();

    Item findById(int theId);

    Item save(Item theItem);

    void deleteById(int theId);

}
