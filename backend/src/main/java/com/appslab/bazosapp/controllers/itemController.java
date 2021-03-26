package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.itemService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping
public class itemController {
    itemService service;

    public itemController(itemService service) {

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
}
