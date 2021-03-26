package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Items;

import java.util.Optional;
import java.util.Set;

public interface itemService {
    void saveItem(Items item);
    Iterable<Items> roster();
    Optional<Items> detail(long id);
}
