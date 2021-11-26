package co.edu.unbosque.model.jpa.repositories;

import co.edu.unbosque.model.jpa.entities.PetCase;


import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<PetCase> findById(Integer id);

    List<PetCase> findAll();

    Optional<PetCase> save(PetCase petcase);
}
