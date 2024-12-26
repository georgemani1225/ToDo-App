package com.geo.todoapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.todoapp.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by first name(change findAll method in EmployeeServiceImpl)
    public List<Item> findAllByOrderByItemDateAsc();

}
