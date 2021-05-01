package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
}
