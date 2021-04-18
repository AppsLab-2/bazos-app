package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,String> {
}
