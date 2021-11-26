package co.edu.unbosque.model.jpa.repositories;


import co.edu.unbosque.model.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> findById(Integer visit_id);

    List<Visit> findAll();

    Optional<Visit> save(Visit visit);
}
