package org.aco.museumapi.repository;

import org.aco.museumapi.model.Exhibit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitRepository extends JpaRepository<Exhibit, String> {
}
