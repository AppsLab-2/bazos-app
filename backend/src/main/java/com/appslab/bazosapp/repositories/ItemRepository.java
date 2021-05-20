package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends JpaRepository<Items,Long> {
}
