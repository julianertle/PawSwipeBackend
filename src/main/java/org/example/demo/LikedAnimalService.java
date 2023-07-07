package org.example.demo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link LikedAnimalService} is a service class that handles operations related to liked animals.
 * This class provides methods for liking, disliking, and retrieving liked animals.
 * It uses the {@link LikedAnimalRepository} bean for accessing liked animal data from the database.
 * The class is annotated with Spring's @Service annotation to indicate that it is a service component.
 * It handles the business logic for liked animals.
 *
 * @author Julian Ertle
 */
@Service
public class LikedAnimalService {
    private final LikedAnimalRepository likedAnimalRepository;

    /**
     * Constructs a new instance of LikedAnimalService with the specified LikedAnimalRepository.
     *
     * @param likedAnimalRepository The LikedAnimalRepository to be used for accessing liked animal data.
     */
    @Autowired
    public LikedAnimalService(LikedAnimalRepository likedAnimalRepository) {
        this.likedAnimalRepository = likedAnimalRepository;
    }

    /**
     * Likes an animal by associating it with a profile.
     *
     * @param profileId The ID of the profile.
     * @param animalId  The ID of the animal to be liked.
     */
    public void likeAnimal(int profileId, int animalId) {
        Profile profile = new Profile();
        profile.setProfile_id(profileId);

        Animal animal = new Animal();
        animal.setAnimalId(animalId);

        LikedAnimal likedAnimal = new LikedAnimal();
        likedAnimal.setProfile(profile);
        likedAnimal.setAnimal(animal);

        likedAnimalRepository.save(likedAnimal);
    }

    /**
     * Dislikes an animal by removing its association with a profile.
     *
     * @param profileId The ID of the profile.
     * @param animalId  The ID of the animal to be disliked.
     * @throws NotFoundException if the liked animal is not found for the specified profile ID and animal ID.
     */
    @Transactional
    public void dislikeAnimal(int profileId, int animalId) throws NotFoundException {
        LikedAnimal likedAnimal = likedAnimalRepository.findByProfileIdAndAnimalId(profileId, animalId);
        if (likedAnimal == null) {
            throw new NotFoundException("Liked animal not found for profileId: " + profileId + " and animalId: " + animalId);
        }
        likedAnimalRepository.deleteByProfileIdAndAnimalId(profileId, animalId);
    }

    /**
     * Retrieves the IDs of all liked animals associated with the specified profile.
     *
     * @param profileId The ID of the profile.
     * @return A list of liked animal IDs associated with the profile.
     */
    public List<Integer> getLikedAnimalIds(int profileId) {
        List<LikedAnimal> likedAnimals = likedAnimalRepository.findByProfileId(profileId);
        List<Integer> likedAnimalIds = new ArrayList<>();

        for (LikedAnimal likedAnimal : likedAnimals) {
            likedAnimalIds.add(likedAnimal.getAnimal().getAnimal_id());
        }
        return likedAnimalIds;
    }
}


