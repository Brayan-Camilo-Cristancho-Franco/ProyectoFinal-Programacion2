package co.edu.unbosque.model.jpa.repositories;



import co.edu.unbosque.model.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository {

    List<UserApp> findAll();

    Optional<UserApp> findByName(String name);

    Optional<UserApp> save(UserApp userapp);

    Optional<UserApp> findByUsername(String username);

    Optional<UserApp> update(String username, String email);
}