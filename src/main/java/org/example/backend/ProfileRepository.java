package org.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The ProfileRepository interface provides CRUD operations and custom query methods
 * for accessing and managing Profile entities in the database.
 * @author Julian Ertle
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByEmail(String email);
}