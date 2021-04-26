package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.ItemService;

import java.util.Optional;

@RestController
@RequestMapping
public class ItemController {
    ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/newitem")
    public void newItem(@RequestBody Items item){
    service.saveItem(item);
    }

    @GetMapping("/showitems")
    public Iterable <Items> showItems(){
        return service.roster();
    }

    @GetMapping("/detailitem/{id}")
    public Optional <Items> detailItems(@PathVariable long id){

        return service.detail(id);
    }

    @GetMapping("/deleteitem/{id}")
    public void deleteItem(@PathVariable long id) {
        service.deleteItem(id);
    }
}
