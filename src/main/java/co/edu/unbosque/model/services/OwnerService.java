package co.edu.unbosque.model.services;

import co.edu.unbosque.model.jpa.entities.Owner;
import co.edu.unbosque.model.jpa.repositories.OwnerRepository;
import co.edu.unbosque.model.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.model.resources.pojos.OwnerPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless

public class OwnerService {

    OwnerRepository ownerRepository;

    public List<OwnerPojo> listOwners() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPojo> ownersPojo = new ArrayList<>();
        for (Owner owner : owners) {
            ownersPojo.add(new OwnerPojo(
                    owner.getUsername(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAdress(),
                    owner.getNeighborhood()

            ));
        }

        return ownersPojo;

    }

    public Owner saveOwner(String username, String person_id, String name, String adress, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(username, person_id, name, adress, neighborhood);
        Owner persistedOwner = ownerRepository.save(owner).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;

    }

    public void updateOwner(String username, String name, String addres, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        ownerRepository.update(username, name, addres, neighborhood);

        entityManager.close();
        entityManagerFactory.close();

    }
}