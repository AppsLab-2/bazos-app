package com.appslab.bazosapp.repositories;

import com.appslab.bazosapp.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Long>, JpaSpecificationExecutor<User> {
    Optional<Users> findByEmail(String email);
}
