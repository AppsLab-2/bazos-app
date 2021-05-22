package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.services.UserService;
import com.sun.istack.Nullable;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.ItemService;

import java.util.Optional;

@RestController
@RequestMapping
public class ItemController {
    ItemService service;
    Users users;


    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/newitem")
    public void newItem(@RequestBody Items item){
    service.saveItem(item);
    }

    @GetMapping("/showitems")
    public Iterable <Items> showItems(Users users){

        return service.roster();
    }

    @GetMapping("/detailitem/{id}")
    public Optional <Items>detailItems(@PathVariable long id){


        return service.detail(id);
    }

    @GetMapping("/deleteitem/{id}")
    public void deleteItem(@PathVariable long id) {
        service.deleteItem(id);
    }
    @GetMapping("/showuseritems")
    public Iterable <Items> showUserItems(Users users){
        return  users.getItems();
    }
}
