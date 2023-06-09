package org.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LikedAnimalRepository extends CrudRepository<LikedAnimal, Integer> {

    @Modifying
    @Query("DELETE FROM LikedAnimal la WHERE la.profile.profile_id = :profileId AND la.animal.animal_id = :animalId")
    void deleteByProfileIdAndAnimalId(@Param("profileId") int profileId, @Param("animalId") int animalId);

    @Query("SELECT la FROM LikedAnimal la WHERE la.profile.profile_id = :profileId AND la.animal.animal_id = :animalId")
    LikedAnimal findByProfileIdAndAnimalId(@Param("profileId") int profileId, @Param("animalId") int animalId);
}

