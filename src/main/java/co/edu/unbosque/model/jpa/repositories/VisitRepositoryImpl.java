package co.edu.unbosque.model.jpa.repositories;

import co.edu.unbosque.model.jpa.entities.Visit;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository {

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Visit> findById(Integer visit_id) {
        Visit book = entityManager.find(Visit.class, visit_id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit").getResultList();
    }


    public Optional<Visit> save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
