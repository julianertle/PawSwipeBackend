package org.example.backend;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The LikedAnimalRepository interface provides CRUD operations and custom query methods
 * for accessing and managing LikedAnimal entities in the database.
 *
 * @author Julian Ertle
 */
public interface LikedAnimalRepository extends CrudRepository<LikedAnimal, Integer> {

    /**
     * Deletes a LikedAnimal record based on the provided profile ID and animal ID.
     *
     * @param profileId The profile ID.
     * @param animalId  The animal ID.
     */
    @Modifying
    @Query("DELETE FROM LikedAnimal la WHERE la.profile.profile_id = :profileId AND la.animal.animal_id = :animalId")
    void deleteByProfileIdAndAnimalId(@Param("profileId") int profileId, @Param("animalId") int animalId);

    /**
     * Retrieves a LikedAnimal record based on the provided profile ID and animal ID.
     *
     * @param profileId The profile ID.
     * @param animalId  The animal ID.
     * @return The LikedAnimal record if found, or null if not found.
     */
    @Query("SELECT la FROM LikedAnimal la WHERE la.profile.profile_id = :profileId AND la.animal.animal_id = :animalId")
    LikedAnimal findByProfileIdAndAnimalId(@Param("profileId") int profileId, @Param("animalId") int animalId);

    /**
     * Retrieves a list of LikedAnimal records based on the provided profile ID.
     *
     * @param profileId The profile ID.
     * @return A list of LikedAnimal records associated with the profile ID.
     */
    @Query("SELECT la FROM LikedAnimal la WHERE la.profile.profile_id = :profileId")
    List<LikedAnimal> findByProfileId(@Param("profileId") int profileId);
}

