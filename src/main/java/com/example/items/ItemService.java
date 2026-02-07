package com.example.items;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private Long idCounter = 1L;

    public Item addItem(Item item) {

        // Input validation
        if(item.getName() == null || item.getName().isEmpty()){
            throw new RuntimeException("Item name is required");
        }

        item.setId(idCounter++);
        items.add(item);
        return item;
    }

    public Optional<Item> getItemById(Long id){
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
    
    public List<Item> getAllItems(){
        return items;
    }
}
