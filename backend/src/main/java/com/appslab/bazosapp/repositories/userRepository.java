package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<Users,String> {
}
