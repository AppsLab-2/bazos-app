package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Items;
import org.springframework.data.repository.CrudRepository;

public interface itemRepository extends CrudRepository<Items,String> {
}
