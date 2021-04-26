package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Items;
import org.springframework.stereotype.Service;
import com.appslab.bazosapp.repositories.ItemRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository repo;

    public ItemServiceImpl(ItemRepository rep) {

        this.repo = rep;
    }

    @Override
    public void saveItem(Items item) {

        repo.save(item);
        Set<Items>roster=new HashSet<>();
        roster.add(item);

    }
    @Override
    public Iterable<Items>roster(){
    return repo.findAll();
    }

    public Optional<Items> detail(long id){
        return repo.findById(id);
    }
    @Override
    public void deleteItem(long id) { repo.deleteById(id); }
}
