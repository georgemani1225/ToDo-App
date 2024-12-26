package com.geo.todoapp.service;

import com.geo.todoapp.dao.ItemRepository;
import com.geo.todoapp.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private ItemRepository itemRepository;

    @Autowired
    public ToDoServiceImpl(ItemRepository theItemRepository) {
    	itemRepository = theItemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAllByOrderByItemDateAsc();
    }

    @Override
    public Item findById(int theId) {
        Optional<Item> result = itemRepository.findById(theId);

        Item theItem = null;

        if (result.isPresent()) {
        	theItem = result.get();
        }
        else {
            throw new RuntimeException("Did not find item id - " + theId);
        }

        return theItem;
    }

    @Override
    public Item save(Item theItem) {
        return itemRepository.save(theItem);
    }

    @Override
    public void deleteById(int theId) {
        itemRepository.deleteById(theId);
    }
}






