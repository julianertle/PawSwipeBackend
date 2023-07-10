package org.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The AnimalRepository interface provides CRUD operations and custom query methods
 * for accessing and managing Animal entities in the database.
 *
 * @author Julian Ertle
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
