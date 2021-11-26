package co.edu.unbosque.model.services;


import co.edu.unbosque.model.jpa.entities.UserApp;
import co.edu.unbosque.model.jpa.entities.Vet;
import co.edu.unbosque.model.jpa.repositories.UserAppRepository;
import co.edu.unbosque.model.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.model.jpa.repositories.VetRepository;
import co.edu.unbosque.model.jpa.repositories.VetRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class VetService {

    VetRepository vetRepository;
    UserAppRepository userAppRepository;

    public void saveVet(String name, String address, String neighborhood,String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        Optional<UserApp> userapp = userAppRepository.findByUsername(username);
        userapp.ifPresent(p -> {
            p.addVet(new Vet(name, address,neighborhood));
            userAppRepository.save(p);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
    public void updateVet(String username, String name, String address, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.update(username,name,address,neighborhood);

        entityManager.close();
        entityManagerFactory.close();

    }
}
