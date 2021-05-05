package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.models.Users;

import java.util.Optional;
import java.util.Set;

public interface ItemService {
    void saveItem(Items item);
    Iterable<Items> roster();
    Optional <Items>detail(long id);
    void deleteItem(long id);


}
