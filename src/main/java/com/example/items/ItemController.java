package com.example.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    // Add item
    @PostMapping
    public Item addItem(@RequestBody Item item){
        return service.addItem(item);
    }

    // Get item by ID
    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id){

        Optional<Item> item = service.getItemById(id);

        return item.orElseThrow(() ->
                new RuntimeException("Item not found"));
    }
    
    @GetMapping
    public List<Item> getAllItems(){
        return service.getAllItems();
    }
}
