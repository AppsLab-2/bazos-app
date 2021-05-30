package com.appslab.bazosapp.controllers;
import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.repositories.ItemRepository;
import com.appslab.bazosapp.services.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import com.appslab.bazosapp.services.ItemService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping
public class ItemController {
    ItemService service;
    UserService userService;
    ItemRepository itemRepository;

    public ItemController(ItemService service, UserService userService,ItemRepository itemRepository) {
        this.service = service;
        this.userService=userService;
        this.itemRepository=itemRepository;
    }


    @PostMapping("/newitem")
    public void newItem(@RequestBody Items item){
    service.saveItem(item);
    }

    @GetMapping("/showitems")
    public Iterable <Items> showItems(){

        return service.roster();
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
    @GetMapping("/showuseritems")
    public Set<Items> showUserItems() {


        return userService.getCurrentUser().getItems();
    }
    @GetMapping("/items")
    public Iterable<Items> search(@RequestParam String search){

        return itemRepository.findByNameOrDescriptionContaining(search);
    }

}
