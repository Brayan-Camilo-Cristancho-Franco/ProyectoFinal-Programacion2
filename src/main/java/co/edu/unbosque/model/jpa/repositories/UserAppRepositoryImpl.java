package co.edu.unbosque.model.jpa.repositories;

import co.edu.unbosque.model.jpa.entities.UserApp;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<UserApp> findByUsername(String username) {
        UserApp userapp = entityManager.find(UserApp.class, username);
        return userapp != null ? Optional.of(userapp) : Optional.empty();
    }

    public List<UserApp> findAll() {
        return entityManager.createQuery("from UserApp").getResultList();
    }

    public Optional<UserApp> findByName(String email) {
        UserApp author = entityManager.createNamedQuery("UserApp.findByEmail", UserApp.class)
                .setParameter("email", email)
                .getSingleResult();
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public Optional<UserApp> update(String username, String email) {

        try {
            entityManager.getTransaction().begin();

            UserApp userapp = entityManager.find(UserApp.class, username);
            userapp.setEmail(email);

            //entityManager.update(owner); // Revisar si esto es obligatorio
            entityManager.getTransaction().commit();

            return Optional.of(userapp);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<UserApp> save(UserApp userap) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userap);
            entityManager.getTransaction().commit();
            return Optional.of(userap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}