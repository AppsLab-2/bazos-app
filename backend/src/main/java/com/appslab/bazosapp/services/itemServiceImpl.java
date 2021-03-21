package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Items;
import org.springframework.stereotype.Service;
import com.appslab.bazosapp.repositories.itemRepository;

@Service
public class itemServiceImpl implements itemService{
    itemRepository repo;

    public itemServiceImpl(itemRepository rep) {

        this.repo = repo;
    }

    @Override
    public void saveItem(Items item) {

        repo.save(item);
    }
}
