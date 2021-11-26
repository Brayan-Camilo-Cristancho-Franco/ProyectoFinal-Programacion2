package co.edu.unbosque.model.services;


import co.edu.unbosque.model.jpa.entities.UserApp;
import co.edu.unbosque.model.jpa.repositories.UserAppRepository;
import co.edu.unbosque.model.jpa.repositories.UserAppRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless

public class UserAppService {


    UserAppRepository userappRepository;


    public UserApp saveUserApp(String username, String password, String email, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userapp = new UserApp(username, password, email, role);
        UserApp persistedUserApp = userappRepository.save(userapp).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedUserApp;

    }

    public void updateUserApp(String username, String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);
        userappRepository.update(username, email);

        entityManager.close();
        entityManagerFactory.close();

    }

}