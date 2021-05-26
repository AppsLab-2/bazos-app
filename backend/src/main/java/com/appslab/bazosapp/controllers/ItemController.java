package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.services.UserService;
import com.sun.istack.Nullable;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.ItemService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping
public class ItemController {
    ItemService service;
    UserService servis;

    public ItemController(){

    }
    public ItemController(UserService servis) {
        this.servis = servis;
    }

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


    @GetMapping("/useritems")
    public Set<Items> showUserItems(Users user){

        return user.getItems();
    }
    @GetMapping("/deleteitem/{id}")
    public void deleteItem(@PathVariable long id) {
        service.deleteItem(id);
    }



    @GetMapping("/detailitem/{id}")
    public Optional <Items>detailItems(@PathVariable long id){


        return service.detail(id);
    }

    @GetMapping("/sortitems")
    public Iterable <Items> sortItems(@RequestParam String parameter) {
        Sort sort = Sort.by(parameter);
        return service.sort(sort);
    }

}
