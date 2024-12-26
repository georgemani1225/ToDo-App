package com.geo.todoapp.controller;

import com.geo.todoapp.entity.Item;
import com.geo.todoapp.service.ToDoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class ToDoController {

	private ToDoService toDoService;

	public ToDoController(ToDoService theToDoService) {
		toDoService = theToDoService;
	}

	@GetMapping("/list")
	public String listItems(Model theModel) {

		List<Item> theItems = toDoService.findAll();
		theModel.addAttribute("items", theItems);
		return "list-items";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Item theItem = new Item();
		theModel.addAttribute("item", theItem);
		return "item-form";

	}

	@PostMapping("/save")
	public String saveItem(@ModelAttribute("item") Item theItem) {
		
		theItem.setStatus("Incomplete");
		toDoService.save(theItem);
		return "redirect:/todo/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("itemId") int theId, Model theModel) {

		Item theItem = toDoService.findById(theId);
		theModel.addAttribute("item", theItem);
		return "item-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("itemId") int theId, Model theModel) {

		toDoService.deleteById(theId);
		return "redirect:/todo/list";

	}

	@PostMapping("/markComplete")
	@ResponseBody
	public String markComplete(@RequestParam("itemId") int theId) {
		Item theItem = toDoService.findById(theId);
		if (theItem != null) {
			theItem.setStatus("Complete");
			toDoService.save(theItem);
			return "success";
		} else {
			return "error";
		}
	}

}
