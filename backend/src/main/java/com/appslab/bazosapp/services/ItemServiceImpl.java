package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.appslab.bazosapp.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository repo;

    UserService userService;



    public ItemServiceImpl(ItemRepository repo,UserService userService) {
       this.repo=repo;
        this.userService=userService;
    }

    @Override
    public void saveItem(Items item) {
        item.setUserId(userService.getUserId());
        repo.save(item);
        Set<Items>roster=new HashSet<>();
        roster.add(item);

    }
    @Override
    public Iterable<Items>roster(){
    return repo.findAll();
    }
    @Override
    public Optional<Items> detail(long id){
        return repo.findById(id);

    }
    @Override
    public void deleteItem(long id) { repo.deleteById(id); }
    @Override
    public Iterable<Items> sort(Sort sort) {
        return repo.findAll(sort);
    }
    /*
    @Override
    public Iterable <Items> showUserItems(Users users){
        return users.getItems();
*/
    }


