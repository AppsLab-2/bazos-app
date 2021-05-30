package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items,Long> {
    @Query("select i from Items i where i.name like %?1% or i.description like %?1%")
    Iterable<Items> findByNameOrDescriptionContaining(String query);
}
