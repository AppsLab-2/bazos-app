package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appslab.bazosapp.services.itemService;

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
}
