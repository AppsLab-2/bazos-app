package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.itemService;

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
}
